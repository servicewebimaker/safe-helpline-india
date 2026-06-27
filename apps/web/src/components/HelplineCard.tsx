import type { Helpline } from "@safe-helpline-india/core";
import { ExternalLink, PhoneCall, ShieldCheck } from "lucide-react";
import { getCategoryTone } from "../utils/category";

interface HelplineCardProps {
  helpline: Helpline;
}

export function HelplineCard({ helpline }: HelplineCardProps) {
  const tone = getCategoryTone(helpline.category);

  return (
    <article className="helpline-card">
      <div className="helpline-card__meta">
        <span className={`category-badge category-badge--${tone}`}>
          <ShieldCheck size={15} aria-hidden="true" />
          {helpline.category}
        </span>
        <span className="availability">{helpline.availability}</span>
      </div>

      <div>
        <h3>{helpline.name}</h3>
        <p className="helpline-card__number">{helpline.number}</p>
        <p>{helpline.description}</p>
      </div>

      <dl className="source-facts">
        <div>
          <dt>Country</dt>
          <dd>{helpline.country}</dd>
        </div>
        <div>
          <dt>Last verified</dt>
          <dd>{helpline.lastVerified}</dd>
        </div>
        <div>
          <dt>Status</dt>
          <dd>{helpline.verificationStatus}</dd>
        </div>
      </dl>

      <div className="helpline-card__actions">
        <a className="button button--primary" href={`tel:${helpline.number}`} aria-label={`Open phone dialer for ${helpline.name} at ${helpline.number}`}>
          <PhoneCall size={18} aria-hidden="true" />
          Call {helpline.number}
        </a>
        <a className="button button--ghost" href={helpline.sourceUrl} target="_blank" rel="noreferrer">
          <ExternalLink size={18} aria-hidden="true" />
          Source
        </a>
      </div>
    </article>
  );
}
