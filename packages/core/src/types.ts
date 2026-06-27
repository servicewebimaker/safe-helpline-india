export const HELPLINE_CATEGORIES = ["Emergency", "Women Safety"] as const;

export type HelplineCategory = (typeof HELPLINE_CATEGORIES)[number];

export type VerificationStatus = "verified";

export interface Helpline {
  id: string;
  name: string;
  number: string;
  category: HelplineCategory;
  country: "IN";
  availability: string;
  description: string;
  sourceUrl: string;
  sourceName: string;
  lastVerified: string;
  verificationStatus: VerificationStatus;
}

export interface SourceMetadata {
  id: string;
  title: string;
  publisher: string;
  url: string;
  sourceType: "official-government-page" | "public-official-page";
  lastAccessed: string;
  notes: string;
}

export interface ValidationResult {
  valid: boolean;
  errors: string[];
}
