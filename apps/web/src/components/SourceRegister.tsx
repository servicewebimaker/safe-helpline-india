import type { Helpline } from "@safe-helpline-india/core";
import { ExternalLink } from "lucide-react";

interface SourceRegisterProps {
  helplines: Helpline[];
}

export function SourceRegister({ helplines }: SourceRegisterProps) {
  return (
    <section className="source-register" aria-labelledby="source-register-title">
      <div className="section-heading">
        <p className="eyebrow">Verification register</p>
        <h2 id="source-register-title">Every included helpline links back to its public source.</h2>
      </div>
      <div className="source-table" role="table" aria-label="Verified helpline source register">
        <div className="source-table__row source-table__row--head" role="row">
          <span role="columnheader">Helpline</span>
          <span role="columnheader">Source</span>
          <span role="columnheader">Verified</span>
        </div>
        {helplines.map((helpline) => (
          <div className="source-table__row" role="row" key={helpline.id}>
            <span role="cell">{helpline.name}</span>
            <a role="cell" href={helpline.sourceUrl} target="_blank" rel="noreferrer">
              {helpline.sourceName}
              <ExternalLink size={14} aria-hidden="true" />
            </a>
            <span role="cell">{helpline.lastVerified}</span>
          </div>
        ))}
      </div>
    </section>
  );
}
