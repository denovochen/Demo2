# MultiHub Android App 📱

[![License](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Platform](https://img.shields.io/badge/Platform-Android-green.svg)](https://developer.android.com)
[![Language](https://img.shields.io/badge/Language-Java-orange.svg)](https://www.java.com)

**MultiHub** 是我的第一个 Android 开发项目，作为本科期末大作业完成。它是一个多功能集成应用，旨在通过一个入口提供音乐播放、网页浏览和日常记录三大核心功能。

---

## 🚀 功能模块

本应用主要包含以下三个核心功能：

1.  **🎵 音乐播放器 (Music Player)**
    * 支持本地音频文件扫描与播放。
    * 提供基础的播放控制：播放/暂停、上一曲/下一曲、进度条拖动。
2.  **🌐 内置浏览器 (Mini Browser)**
    * 基于 WebView 实现，支持快速访问网页。
    * 具备简单的地址栏输入和页面加载功能。
3.  **📝 智能备忘录 (Notebook)**
    * 支持创建、编辑和删除笔记。
    * 本地数据持久化存储，记录你的灵感与琐事。


## 🛠 技术栈

* **开发语言:** Java
* **开发环境:** Android Studio
* **系统组件:** `WebView`, `Service` (用于音乐后台播放), `SQLite` (用于备忘录存储)
* **构建工具:** Gradle

---

## 📂 项目结构说明

```text
app/src/main/
├── java/com/example/demo2/
│   ├── music/         # 音乐播放相关逻辑
│   ├── browser/       # WebView 相关实现
│   ├── notebook/      # 数据库与笔记界面
│   └── MainActivity.java
└── res/
    ├── layout/        # 界面 XML 布局文件
    └── drawable/      # 图标与 UI 资源
