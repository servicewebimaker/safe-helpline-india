import { AlertTriangle, PhoneCall, ShieldCheck } from "lucide-react";

export function EmergencyBanner() {
  return (
    <section className="emergency-banner" aria-labelledby="emergency-title">
      <div className="emergency-banner__icon" aria-hidden="true">
        <AlertTriangle size={24} />
      </div>
      <div className="emergency-banner__content">
        <p className="eyebrow">Safety disclaimer</p>
        <h2 id="emergency-title">In immediate danger, use the phone dialer or local emergency services.</h2>
        <p>
          This independent open-source toolkit shares verified public helpline information. It does not dispatch help,
          track location, store contacts, or replace trained emergency responders.
        </p>
      </div>
      <div className="emergency-banner__actions" aria-label="Emergency call actions">
        <a className="button button--danger" href="tel:112" aria-label="Open phone dialer for 112 emergency response">
          <PhoneCall size={18} aria-hidden="true" />
          Call 112
        </a>
        <a className="button button--secondary" href="tel:181" aria-label="Open phone dialer for 181 women helpline">
          <ShieldCheck size={18} aria-hidden="true" />
          Call 181
        </a>
      </div>
    </section>
  );
}
