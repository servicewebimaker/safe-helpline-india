import { describe, expect, it } from "vitest";
import {
  getAllHelplines,
  getHelplineByNumber,
  getHelplinesByCategory,
  searchHelplines,
  validateHelplineData
} from "./index";

describe("verified helpline data", () => {
  it("contains only the two verified starting helplines", () => {
    const helplines = getAllHelplines();

    expect(helplines).toHaveLength(2);
    expect(helplines.map((helpline) => helpline.number).sort()).toEqual(["112", "181"]);
  });

  it("validates the bundled data", () => {
    const result = validateHelplineData(getAllHelplines());

    expect(result.valid).toBe(true);
    expect(result.errors).toEqual([]);
  });

  it("looks up helplines by number and category", () => {
    expect(getHelplineByNumber("tel:112")?.id).toBe("erss-112");
    expect(getHelplinesByCategory("Women Safety")[0]?.number).toBe("181");
  });

  it("searches by source, category, and description text", () => {
    expect(searchHelplines("women")).toHaveLength(2);
    expect(searchHelplines("myScheme")).toHaveLength(1);
    expect(searchHelplines("", "Emergency")[0]?.number).toBe("112");
  });
});
