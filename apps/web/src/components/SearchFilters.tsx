import { HELPLINE_CATEGORIES, type HelplineCategory } from "@safe-helpline-india/core";
import { Search } from "lucide-react";
import type { CategoryFilter } from "../utils/category";

interface SearchFiltersProps {
  query: string;
  category: CategoryFilter;
  onQueryChange: (query: string) => void;
  onCategoryChange: (category: CategoryFilter) => void;
}

export function SearchFilters({ query, category, onQueryChange, onCategoryChange }: SearchFiltersProps) {
  const filters: CategoryFilter[] = ["All", ...HELPLINE_CATEGORIES];

  return (
    <div className="filters" aria-label="Search and filter verified helplines">
      <label className="search-field" htmlFor="helpline-search">
        <Search size={18} aria-hidden="true" />
        <span className="sr-only">Search helplines</span>
        <input
          id="helpline-search"
          value={query}
          onChange={(event) => onQueryChange(event.target.value)}
          placeholder="Search by number, category, or source"
          type="search"
          autoComplete="off"
        />
      </label>

      <div className="filter-buttons" aria-label="Category filters">
        {filters.map((filter) => (
          <button
            key={filter}
            className="filter-button"
            type="button"
            aria-pressed={category === filter}
            onClick={() => onCategoryChange(filter)}
          >
            {filter}
          </button>
        ))}
      </div>
    </div>
  );
}
