import type { Helpline, HelplineCategory } from "./types";

export const VERIFIED_HELPLINES: readonly Helpline[] = [
  {
    id: "erss-112",
    name: "Emergency Response Support System (ERSS)",
    number: "112",
    category: "Emergency",
    country: "IN",
    availability: "24x7",
    description:
      "India's unified emergency number for reporting emergencies. ERSS is designed to route actionable distress calls to the appropriate emergency services, including police, health, fire, disaster, women and children helpline systems.",
    sourceUrl: "https://www.mha.gov.in/en/commoncontent/emergency-response-support-system-erss",
    sourceName: "Ministry of Home Affairs, Government of India",
    lastVerified: "2026-06-26",
    verificationStatus: "verified"
  },
  {
    id: "women-helpline-181",
    name: "Women Helpline",
    number: "181",
    category: "Women Safety",
    country: "IN",
    availability: "24x7",
    description:
      "Women Helpline provides emergency and non-emergency response through telephonic short-code 181 for women, including referral to appropriate authorities and information about women-related government schemes and support services.",
    sourceUrl: "https://www.myscheme.gov.in/schemes/whl-181",
    sourceName: "myScheme, Government of India",
    lastVerified: "2026-06-26",
    verificationStatus: "verified"
  }
] as const;

export function getAllHelplines(): Helpline[] {
  return VERIFIED_HELPLINES.map((helpline) => ({ ...helpline }));
}

export function getHelplineByNumber(number: string): Helpline | undefined {
  const normalizedNumber = number.replace(/\D/g, "");
  const helpline = VERIFIED_HELPLINES.find((item) => item.number === normalizedNumber);
  return helpline ? { ...helpline } : undefined;
}

export function getHelplinesByCategory(category: HelplineCategory): Helpline[] {
  return VERIFIED_HELPLINES.filter((helpline) => helpline.category === category).map((helpline) => ({
    ...helpline
  }));
}

export function searchHelplines(query: string, category?: HelplineCategory | "All"): Helpline[] {
  const normalizedQuery = query.trim().toLowerCase();
  const normalizedCategory = category === "All" ? undefined : category;

  return VERIFIED_HELPLINES.filter((helpline) => {
    const matchesCategory = normalizedCategory ? helpline.category === normalizedCategory : true;
    const matchesQuery =
      normalizedQuery.length === 0 ||
      [helpline.name, helpline.number, helpline.category, helpline.description, helpline.sourceName]
        .join(" ")
        .toLowerCase()
        .includes(normalizedQuery);

    return matchesCategory && matchesQuery;
  }).map((helpline) => ({ ...helpline }));
}
