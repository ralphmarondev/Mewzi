# 🌼 Mewzi — Where Ideas Purr!

Welcome to **Mewzi** — a pastel-yellow social app where soft thoughts, tiny rambles, and meow-worthy moments live.  
Powered by Django REST 🐍 and Jetpack Compose 🧵, and brewed on Ubuntu ☕🐧.

<!-- <img src="public/mewzi-banner.png" alt="Mewzi banner" width="100%" /> -->

---

## 🐾 What is Mewzi?

**Mewzi** is a cute, community-first platform inspired by Threads and Reddit — with a focus on **multi-tenancy**, smooth UX, and a soft aesthetic.

✨ Think: short posts (called **meows**), pastel yellow UI, gentle threads, and a cozy digital space to express and explore.

---

## ✨ Features

- 🐱 Post **meows** (tiny text + tag combos)
- 💬 Comment and react with **paw prints**
- 🎨 **Pastel yellow UI** for light, happy vibes
- 🐘 **PostgreSQL** + **multi-tenancy** support (SaaS-friendly!)
- 🛠️ **Django REST Framework** backend
- 📱 **Jetpack Compose** Android frontend
- 🐧 Built with love on **Ubuntu 22.04.2 LTS**

---

## 🧰 Tech Stack

| Layer         | Technology                         |
| ------------- | ---------------------------------- |
| Backend       | Django REST Framework + PostgreSQL |
| Multi-tenancy | `django-tenants`                   |
| Frontend      | Jetpack Compose (Android)          |
| Design        | Pastel Yellow + Cute UI            |
| OS            | Ubuntu 22.04.2 LTS                 |

---

## 🚀 Getting Started

### 1. Clone the repo

```bash
git clone https://github.com/ralphmarondev/Mewzi.git
cd Mewzi
```

### 2. Backend Setup

```bash
cd api
python -m venv .venv
source .venv/bin/activate
pip install -r requirements.txt

# Migrate and run
python manage.py migrate
python manage.py runserver
```

📦 PostgreSQL must be running locally. Make sure your `.env` or `settings.py` has correct DB credentials.

### 3. Frontend (Jetpack Compose)

Open `android/` in Android Studio and run on emulator or device.

---

## 🧪 Tenancy Mode

Mewzi uses **schema-based multi-tenancy** so each community (or "cluster of cats") can live in its own secure schema.
Multi-tenant logic powered by `django-tenants`.

---

## 🐣 Dev Notes

- Works beautifully on **Ubuntu 22.04.2 LTS**
- Uses a soft, round design system
- Targets Android 9+ with Compose Material 3
- Great for learning **fullstack architecture**

---

## 📄 License

```text
MIT License

Copyright (c) 2025 Ralph Maron A. Eda

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction...
```

---

> Made with 🐾 by Ralph Maron A. Eda
> _"Let your thoughts meow. Softly. Gently. Openly."_
