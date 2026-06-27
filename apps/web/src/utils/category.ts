import type { HelplineCategory } from "@safe-helpline-india/core";

export type CategoryFilter = "All" | HelplineCategory;

export function getCategoryTone(category: HelplineCategory): "emergency" | "women" {
  return category === "Emergency" ? "emergency" : "women";
}
