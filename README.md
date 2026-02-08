# FullFundApp — Scholarships & Funded Positions Hub (Android)

**FullFundApp** is an Android app that displays **scholarships, fully funded opportunities, and funded academic positions** (e.g., MSc/PhD) in a clean, modern feed.  
The app is designed to be **lightweight**, **fast**, and **easy to maintain**.

> **App name (Persian):** مرجع فاند و پوزیشن‌های تحصیلی  
> **Android package:** `com.aghakhani.fullfundapp`  
> **Repository:** https://github.com/k-aghakhani/FullFundApp

---

## ✨ Features

- ✅ Online feed (content can be updated without releasing a new app version)
- ✅ Shows key fields: country, university, level, fund type, deadline
- ✅ One-tap open link (official page / apply link)
- ✅ Country flag icon per item (mapped by `countryCode`)
- ✅ Material UI with cards + RecyclerView
- ✅ Simple, clean structure: UI + repository + network layer

---

## 🧱 Tech Stack

- **Language:** Java  
- **UI:** Material Components (Material 3), RecyclerView  
- **Networking:** Retrofit + Gson  
- **HTTP:** OkHttp (+ logging interceptor in debug)

---

## 🚀 Getting Started

### 1) Clone
```bash
git clone https://github.com/k-aghakhani/FullFundApp.git
```

### 2) Open in Android Studio
Open Android Studio → **Open** → select the project directory → wait for Gradle sync.

### 3) Configure API Base URL
This repository contains **Android code only**. The backend is **not included**.  
Update the base URL in:

`app/src/main/java/com/aghakhani/fullfundapp/data/remote/RetrofitClient.java`

Example:
```java
// Base URL MUST end with '/'
private static final String BASE_URL = "https://YOUR_DOMAIN/YOUR_PATH/";
```

### 4) Run
Connect a device or start an emulator → press **Run** ▶️

---

## 🌐 API Contract (Expected JSON)

The app expects an endpoint like:
```
GET /api/posts.php?page=1&limit=30
```

Example response:
```json
{
  "data": [
    {
      "id": 1,
      "title": "Fully Funded PhD - Computer Science (AI/ML)",
      "university": "University of Toronto",
      "country": "Canada",
      "countryCode": "CA",
      "level": "PhD",
      "fundType": "Fully Funded",
      "deadline": "2026-02-10",
      "link": "https://www.utoronto.ca/",
      "createdAt": 1767654532
    }
  ],
  "page": 1,
  "limit": 30,
  "total": 1
}
```

### Field Notes
- `countryCode` should be a 2-letter code (e.g., `CA`, `DE`, `GB`) used for flag mapping.
- `deadline` should be `YYYY-MM-DD` (or `null` if unknown).

---

## 🏳️ Country Flags

Flags are mapped using `countryCode`.

To add a new flag:
1. Add a drawable (vector) to `res/drawable/`
2. Map it in `FlagMapper.java`

Example mapping:
- `DE` → `R.drawable.flag_germany_simple`

---

## 🔐 Security Notes (Important)

- Do **not** commit secrets (tokens, credentials, private keys).
- Do **not** store database credentials in the Android app.
- Any key inside an APK can be extracted; treat mobile apps as **public clients**.
- Protect admin/management endpoints on the server side with proper authentication.

---

## 🗺️ Roadmap

Planned improvements:
- 🔜 Full Search & Filters (country / level / fund type / region / sorting)
- 🔜 Details screen (share / copy / improved apply flow)
- 🔜 Pagination / Load more
- 🔜 Favorites (saved opportunities)
- 🔜 Deadline reminders (notifications)

---

## 👤 Author

**Kiarash Aghakhani**  
- GitHub: https://github.com/k-aghakhani
- Email: kiarash1988@gmail.com


Made with ❤️ and ☕






