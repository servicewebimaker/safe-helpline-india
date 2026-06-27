import { useMemo, useState } from "react";
import { getAllHelplines, searchHelplines } from "@safe-helpline-india/core";
import { CheckCircle2, Github, HeartHandshake, PhoneCall, ShieldCheck } from "lucide-react";
import { EmergencyBanner } from "./components/EmergencyBanner";
import { HelplineCard } from "./components/HelplineCard";
import { PrivacyNote } from "./components/PrivacyNote";
import { SearchFilters } from "./components/SearchFilters";
import { SourceRegister } from "./components/SourceRegister";
import type { CategoryFilter } from "./utils/category";

function App() {
  const [query, setQuery] = useState("");
  const [category, setCategory] = useState<CategoryFilter>("All");
  const allHelplines = useMemo(() => getAllHelplines(), []);
  const filteredHelplines = useMemo(() => searchHelplines(query, category), [category, query]);

  return (
    <div className="app-shell">
      <header className="site-header">
        <a className="brand" href="#top" aria-label="Safe Helpline India home">
          <span className="brand__mark" aria-hidden="true">
            <ShieldCheck size={21} />
          </span>
          <span>Safe Helpline India</span>
        </a>
        <nav className="site-nav" aria-label="Primary navigation">
          <a href="#directory">Directory</a>
          <a href="#privacy">Privacy</a>
          <a href="#sources">Sources</a>
        </nav>
      </header>

      <main id="top">
        <section className="hero" aria-labelledby="hero-title">
          <div className="hero__copy">
            <p className="eyebrow">Open source. Offline friendly. Verified public sources only.</p>
            <h1 id="hero-title">Safe Helpline India</h1>
            <p>
              A privacy-first emergency and women-safety helpline toolkit for India, built around a deliberately small
              verified dataset and clear source links.
            </p>
            <div className="hero__actions">
              <a className="button button--danger" href="tel:112" aria-label="Open phone dialer for 112">
                <PhoneCall size={18} aria-hidden="true" />
                Call 112
              </a>
              <a className="button button--secondary" href="tel:181" aria-label="Open phone dialer for 181">
                <HeartHandshake size={18} aria-hidden="true" />
                Call 181
              </a>
            </div>
          </div>

          <div className="trust-strip" aria-label="Project safeguards">
            <div>
              <CheckCircle2 size={20} aria-hidden="true" />
              <span>2 verified helplines</span>
            </div>
            <div>
              <CheckCircle2 size={20} aria-hidden="true" />
              <span>No tracking or cookies</span>
            </div>
            <div>
              <CheckCircle2 size={20} aria-hidden="true" />
              <span>No government affiliation claimed</span>
            </div>
          </div>
        </section>

        <EmergencyBanner />

        <section className="directory-section" id="directory" aria-labelledby="directory-title">
          <div className="section-heading">
            <p className="eyebrow">Helpline directory</p>
            <h2 id="directory-title">Verified public safety numbers</h2>
            <p>
              Search and filter the currently verified entries. State-wise and local data is intentionally excluded
              until it can be verified from official or public sources.
            </p>
          </div>

          <SearchFilters
            query={query}
            category={category}
            onQueryChange={setQuery}
            onCategoryChange={setCategory}
          />

          <p className="result-count" aria-live="polite">
            Showing {filteredHelplines.length} of {allHelplines.length} verified helplines.
          </p>

          <div className="helpline-grid">
            {filteredHelplines.map((helpline) => (
              <HelplineCard key={helpline.id} helpline={helpline} />
            ))}
          </div>
        </section>

        <div id="privacy">
          <PrivacyNote />
        </div>

        <div id="sources">
          <SourceRegister helplines={allHelplines} />
        </div>

        <section className="open-source-band" aria-labelledby="open-source-title">
          <Github size={24} aria-hidden="true" />
          <div>
            <p className="eyebrow">Open-source posture</p>
            <h2 id="open-source-title">Designed for public review and careful contribution.</h2>
            <p>
              New helplines must include a source URL, source owner, verification date, and a clear public safety use
              case before they are accepted.
            </p>
          </div>
        </section>
      </main>

      <footer className="site-footer">
        <p>
          Safe Helpline India is an independent open-source project. It is not an emergency dispatch service and does
          not claim government affiliation.
        </p>
      </footer>
    </div>
  );
}

export default App;
