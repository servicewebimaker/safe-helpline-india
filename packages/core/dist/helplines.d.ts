import type { Helpline, HelplineCategory } from "./types";
export declare const VERIFIED_HELPLINES: readonly Helpline[];
export declare function getAllHelplines(): Helpline[];
export declare function getHelplineByNumber(number: string): Helpline | undefined;
export declare function getHelplinesByCategory(category: HelplineCategory): Helpline[];
export declare function searchHelplines(query: string, category?: HelplineCategory | "All"): Helpline[];
//# sourceMappingURL=helplines.d.ts.map