(function () {
  "use strict";

  var HELPLINES = [
    {
      id: "erss-112",
      name: "Emergency Response Support System (ERSS)",
      number: "112",
      category: "Emergency",
      availability: "24x7",
      description:
        "India's unified emergency number for reporting emergencies. ERSS routes actionable distress calls to appropriate emergency services.",
      sourceUrl: "https://www.mha.gov.in/en/commoncontent/emergency-response-support-system-erss",
      sourceName: "Ministry of Home Affairs, Government of India",
      lastVerified: "2026-06-26"
    },
    {
      id: "women-helpline-181",
      name: "Women Helpline",
      number: "181",
      category: "Women Safety",
      availability: "24x7",
      description:
        "Women Helpline provides emergency and non-emergency response through short-code 181, including referral and support information.",
      sourceUrl: "https://www.myscheme.gov.in/schemes/whl-181",
      sourceName: "myScheme, Government of India",
      lastVerified: "2026-06-26"
    }
  ];

  var STYLE_ID = "safe-helpline-widget-styles";

  function escapeHtml(value) {
    return String(value).replace(/[&<>"']/g, function (character) {
      return {
        "&": "&amp;",
        "<": "&lt;",
        ">": "&gt;",
        '"': "&quot;",
        "'": "&#039;"
      }[character];
    });
  }

  function injectStyles() {
    if (document.getElementById(STYLE_ID)) {
      return;
    }

    var style = document.createElement("style");
    style.id = STYLE_ID;
    style.textContent =
      ".shi-widget{font-family:Inter,ui-sans-serif,system-ui,-apple-system,BlinkMacSystemFont,'Segoe UI',sans-serif;color:#17202a;background:#f6f8f5;border:1px solid #d8dfdc;border-radius:8px;padding:16px;max-width:760px}" +
      ".shi-widget *{box-sizing:border-box}.shi-widget__header{display:grid;gap:6px;margin-bottom:14px}.shi-widget__header h2{font-size:1.2rem;line-height:1.2;margin:0}.shi-widget__header p{color:#52606d;margin:0;font-size:.95rem}.shi-widget__grid{display:grid;grid-template-columns:repeat(2,minmax(0,1fr));gap:12px}.shi-card{display:grid;gap:12px;background:#fff;border:1px solid #d8dfdc;border-radius:8px;padding:14px}.shi-card__top{display:flex;align-items:center;justify-content:space-between;gap:8px}.shi-badge{display:inline-flex;align-items:center;border-radius:6px;padding:4px 7px;background:#eef4ef;color:#0e5f5a;font-size:.78rem;font-weight:800}.shi-badge--danger{background:#fff1ef;color:#b42318}.shi-availability{color:#9a6700;font-weight:900;font-size:.78rem}.shi-card h3{font-size:1rem;line-height:1.25;margin:0}.shi-number{font-size:2.1rem;line-height:1;margin:0;color:#084642;font-weight:900}.shi-card p{color:#52606d;margin:0}.shi-actions{display:flex;flex-wrap:wrap;gap:8px}.shi-button{display:inline-flex;align-items:center;justify-content:center;min-height:40px;padding:8px 11px;border-radius:6px;text-decoration:none;font-weight:800;border:1px solid transparent}.shi-button--call{color:#fff;background:#0e5f5a}.shi-button--source{color:#084642;background:#fff;border-color:#d8dfdc}.shi-widget__footer{margin-top:14px;color:#52606d;font-size:.84rem}@media(max-width:620px){.shi-widget__grid{grid-template-columns:1fr}.shi-actions{flex-direction:column}.shi-button{width:100%}}";
    document.head.appendChild(style);
  }

  function cardTemplate(helpline) {
    var tone = helpline.category === "Emergency" ? " shi-badge--danger" : "";

    return (
      '<article class="shi-card">' +
      '<div class="shi-card__top">' +
      '<span class="shi-badge' +
      tone +
      '">' +
      escapeHtml(helpline.category) +
      "</span>" +
      '<span class="shi-availability">' +
      escapeHtml(helpline.availability) +
      "</span>" +
      "</div>" +
      "<div>" +
      "<h3>" +
      escapeHtml(helpline.name) +
      "</h3>" +
      '<p class="shi-number">' +
      escapeHtml(helpline.number) +
      "</p>" +
      "</div>" +
      "<p>" +
      escapeHtml(helpline.description) +
      "</p>" +
      '<div class="shi-actions">' +
      '<a class="shi-button shi-button--call" href="tel:' +
      encodeURIComponent(helpline.number) +
      '" aria-label="Open phone dialer for ' +
      escapeHtml(helpline.name) +
      " at " +
      escapeHtml(helpline.number) +
      '">Call ' +
      escapeHtml(helpline.number) +
      "</a>" +
      '<a class="shi-button shi-button--source" href="' +
      escapeHtml(helpline.sourceUrl) +
      '" target="_blank" rel="noreferrer">Source</a>' +
      "</div>" +
      "</article>"
    );
  }

  function render(target) {
    var root = typeof target === "string" ? document.querySelector(target) : target;

    if (!root) {
      return;
    }

    injectStyles();
    root.innerHTML =
      '<section class="shi-widget" aria-label="Safe Helpline India verified helplines">' +
      '<div class="shi-widget__header">' +
      "<h2>Safe Helpline India</h2>" +
      "<p>Verified emergency and women-safety helplines for India. No tracking, cookies, or external dependencies.</p>" +
      "</div>" +
      '<div class="shi-widget__grid">' +
      HELPLINES.map(cardTemplate).join("") +
      "</div>" +
      '<p class="shi-widget__footer">Independent open-source information widget. It does not dispatch help or claim government affiliation. Last verified: 2026-06-26.</p>' +
      "</section>";
  }

  function autoRender() {
    var targets = document.querySelectorAll("#safe-helpline-widget, [data-safe-helpline-widget]");
    Array.prototype.forEach.call(targets, render);
  }

  window.SafeHelplineWidget = {
    render: render,
    helplines: HELPLINES.map(function (helpline) {
      return Object.assign({}, helpline);
    })
  };

  if (document.readyState === "loading") {
    document.addEventListener("DOMContentLoaded", autoRender);
  } else {
    autoRender();
  }
})();
