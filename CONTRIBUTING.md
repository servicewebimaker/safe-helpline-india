# Contributing

Thank you for considering a contribution to Safe Helpline India.

This project is small by design. The most important rule is that public safety information must be accurate, sourced, and reviewed carefully.

## Development Workflow

1. Fork or branch from the current repository.
2. Install dependencies with `npm install`.
3. Make a focused change.
4. Run `npm run lint`, `npm run test`, and `npm run build`.
5. For Android changes, open `apps/android` in Android Studio and run a Gradle sync/build.
6. Open a pull request with a clear summary and verification notes.

## Data Contributions

New helpline entries must include:

- A public official source URL.
- Source owner or publisher.
- Number and service name.
- Category.
- Country code.
- Availability.
- Last verification date.
- Short description grounded in the source.

Do not submit entries copied from unsourced lists, social posts without official context, comments, forwarded messages, private spreadsheets, or news articles that do not link to an official/public source.

State-wise data is welcome only when each entry has its own verifiable source.

## Code Standards

- Keep changes small and readable.
- Prefer existing project patterns.
- Do not add tracking, analytics, ad SDKs, or unnecessary permissions.
- Do not auto-call, auto-SMS, or collect contacts.
- Use accessible labels for interactive UI.
- Keep documentation honest and specific.

## Commit and Pull Request Notes

Pull requests should include:

- What changed.
- Why it changed.
- How it was tested.
- Source links for data changes.
- Screenshots or recordings for UI changes when helpful.

## Code of Conduct

All contributors are expected to follow [CODE_OF_CONDUCT.md](CODE_OF_CONDUCT.md).
