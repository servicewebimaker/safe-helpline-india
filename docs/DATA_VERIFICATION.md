# Data Verification

Safe Helpline India accepts only verified public safety data.

## Current Included Data

| Helpline | Number | Source |
| --- | --- | --- |
| Emergency Response Support System (ERSS) | 112 | https://www.mha.gov.in/en/commoncontent/emergency-response-support-system-erss |
| Women Helpline | 181 | https://www.myscheme.gov.in/schemes/whl-181 |

Project verification date: 2026-06-26.

## Required Fields

Every entry in `data/helplines.json` must include:

- `id`
- `name`
- `number`
- `category`
- `country`
- `availability`
- `description`
- `sourceUrl`
- `sourceName`
- `lastVerified`
- `verificationStatus`

## Accepted Sources

Accepted sources include:

- Official Government of India ministry pages.
- Official state or union territory department pages.
- Official public scheme pages.
- Official press releases or public documents from government or recognized public institutions.

## Rejected Sources

Do not add a helpline when the only available source is:

- An unsourced list.
- A forwarded message.
- A private spreadsheet.
- A personal blog.
- A news article without an official source link.
- A social media post that cannot be tied to an official public source.

## Review Steps

1. Open the source URL.
2. Confirm the helpline number and service name.
3. Confirm the source owner.
4. Confirm the category and availability from the source or public scheme context.
5. Add or update the JSON entry.
6. Run `npm run test`.
7. Add verification notes to the pull request.

## State-wise Data

State-wise data is not included until each entry can be verified from a source that meets this policy. A single unsourced table is not enough.
