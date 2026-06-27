import { LockKeyhole, UsersRound } from "lucide-react";

export function PrivacyNote() {
  return (
    <section className="privacy-note" aria-labelledby="privacy-note-title">
      <div className="section-heading">
        <p className="eyebrow">Privacy-first safety planning</p>
        <h2 id="privacy-note-title">Trusted contacts belong with the person, not this web app.</h2>
      </div>
      <div className="privacy-note__grid">
        <div className="plain-panel">
          <LockKeyhole size={22} aria-hidden="true" />
          <h3>No contact collection</h3>
          <p>
            The web version does not ask for names, phone numbers, address books, location, cookies, accounts, or
            analytics consent.
          </p>
        </div>
        <div className="plain-panel">
          <UsersRound size={22} aria-hidden="true" />
          <h3>Use trusted contacts safely</h3>
          <p>
            People can save trusted contacts directly on their own phone and agree on a simple check-in phrase outside
            this app.
          </p>
        </div>
      </div>
    </section>
  );
}
