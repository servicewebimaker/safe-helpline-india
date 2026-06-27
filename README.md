# Safe Helpline India

Safe Helpline India is a privacy-first open-source toolkit for verified emergency and women-safety helpline information in India.

The project is intentionally small at launch. It includes only helplines that have been verified from official or public source URLs. It does not claim government affiliation, does not dispatch help, and does not collect personal information.

## Verified Helplines

| Helpline | Number | Category | Source |
| --- | --- | --- | --- |
| Emergency Response Support System (ERSS) | 112 | Emergency | [Ministry of Home Affairs, Government of India](https://www.mha.gov.in/en/commoncontent/emergency-response-support-system-erss) |
| Women Helpline | 181 | Women Safety | [myScheme, Government of India](https://www.myscheme.gov.in/schemes/whl-181) |

Last project verification date: 2026-06-26.

## Features

- React, TypeScript, and Vite web app.
- Kotlin and Jetpack Compose Android app.
- Shared TypeScript core package with validation helpers.
- Static `data/helplines.json` and `data/sources.json`.
- Lightweight embeddable JavaScript widget.
- Click-to-call links that open the user device dialer.
- Search and category filtering for Emergency and Women Safety entries.
- Clear safety, privacy, source, and contribution documentation.
- Offline-first architecture with no backend requirement.

## Monorepo Layout

```text
apps/
  web/        React + TypeScript + Vite app
  android/    Kotlin + Jetpack Compose app
packages/
  core/       Shared helpline types, data helpers, and validation
data/         Verified JSON data and source register
docs/         Data, privacy, safety, and roadmap docs
widget/       Dependency-free embeddable widget
```

## Web App Setup

Requirements:

- Node.js 20 or newer.
- npm.

```bash
npm install
npm run dev
```

The development server runs the web app from `apps/web`.

Useful commands:

```bash
npm run lint
npm run test
npm run build
```

## Android App Setup

Requirements:

- Android Studio.
- Android SDK with API 35 available.
- JDK 17.

Open `apps/android` in Android Studio, let Gradle sync, and run the `app` configuration.

If Gradle is installed locally, you can also run:

```bash
cd apps/android
gradle :app:assembleDebug
```

The Android app uses bundled verified helpline data and does not request location, contacts, SMS, camera, microphone, or storage permissions.

## Widget Usage

```html
<div id="safe-helpline-widget"></div>
<script src="./safe-helpline-widget.js"></script>
```

The widget is dependency-free and makes no tracking, cookie, local storage, or analytics calls.

## Data Verification Policy

Only verified entries are accepted. Each helpline must include:

- Official or public source URL.
- Source owner or publisher.
- Helpline number.
- Category.
- Country.
- Availability.
- Description grounded in the source.
- Last verification date.

Unverified state-wise or local data is not included. See [docs/DATA_VERIFICATION.md](docs/DATA_VERIFICATION.md).

## Privacy Principles

- No accounts.
- No tracking.
- No cookies.
- No contact collection.
- No location collection.
- No auto-call or auto-SMS behavior.
- Dialer opens only after a user action.

See [docs/PRIVACY.md](docs/PRIVACY.md).

## Safety Disclaimer

This project is an independent information directory. It does not dispatch responders and is not a substitute for emergency services, local authorities, trained support workers, or a personal safety plan.

In immediate danger, use the phone dialer and local emergency services. See [docs/SAFETY.md](docs/SAFETY.md).

## Contributing

Contributions are welcome when they preserve the privacy-first and verification-first posture of the project. Start with [CONTRIBUTING.md](CONTRIBUTING.md), then run:

```bash
npm run lint
npm run test
npm run build
```

## Roadmap

See [docs/ROADMAP.md](docs/ROADMAP.md) for realistic next steps, including accessibility audits, stronger data review workflows, Android tests, localization, and carefully verified future data expansion.

## License

MIT. See [LICENSE](LICENSE).
