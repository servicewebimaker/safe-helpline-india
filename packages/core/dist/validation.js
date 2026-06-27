import { HELPLINE_CATEGORIES } from "./types";
const REQUIRED_STRING_FIELDS = [
    "id",
    "name",
    "number",
    "category",
    "country",
    "availability",
    "description",
    "sourceUrl",
    "sourceName",
    "lastVerified",
    "verificationStatus"
];
const isoDatePattern = /^\d{4}-\d{2}-\d{2}$/;
const phoneNumberPattern = /^\d{2,4}$/;
const categories = new Set(HELPLINE_CATEGORIES);
function isRecord(value) {
    return typeof value === "object" && value !== null && !Array.isArray(value);
}
function isValidUrl(value) {
    try {
        const url = new URL(value);
        return url.protocol === "https:";
    }
    catch {
        return false;
    }
}
export function validateHelplineData(data) {
    const errors = [];
    if (!Array.isArray(data)) {
        return {
            valid: false,
            errors: ["Helpline data must be an array."]
        };
    }
    const seenIds = new Set();
    const seenNumbers = new Set();
    data.forEach((entry, index) => {
        const label = `Entry ${index + 1}`;
        if (!isRecord(entry)) {
            errors.push(`${label} must be an object.`);
            return;
        }
        for (const field of REQUIRED_STRING_FIELDS) {
            if (typeof entry[field] !== "string" || String(entry[field]).trim().length === 0) {
                errors.push(`${label} is missing required string field "${field}".`);
            }
        }
        if (typeof entry.id === "string") {
            if (seenIds.has(entry.id)) {
                errors.push(`${label} has duplicate id "${entry.id}".`);
            }
            seenIds.add(entry.id);
        }
        if (typeof entry.number === "string") {
            if (!phoneNumberPattern.test(entry.number)) {
                errors.push(`${label} has an invalid helpline number "${entry.number}".`);
            }
            if (seenNumbers.has(entry.number)) {
                errors.push(`${label} has duplicate number "${entry.number}".`);
            }
            seenNumbers.add(entry.number);
        }
        if (typeof entry.category === "string" && !categories.has(entry.category)) {
            errors.push(`${label} has unsupported category "${entry.category}".`);
        }
        if (entry.country !== "IN") {
            errors.push(`${label} must use country code "IN".`);
        }
        if (entry.verificationStatus !== "verified") {
            errors.push(`${label} must have verificationStatus "verified".`);
        }
        if (typeof entry.sourceUrl === "string" && !isValidUrl(entry.sourceUrl)) {
            errors.push(`${label} must have a valid HTTPS sourceUrl.`);
        }
        if (typeof entry.lastVerified === "string" && !isoDatePattern.test(entry.lastVerified)) {
            errors.push(`${label} must have lastVerified in YYYY-MM-DD format.`);
        }
    });
    return {
        valid: errors.length === 0,
        errors
    };
}
//# sourceMappingURL=validation.js.map