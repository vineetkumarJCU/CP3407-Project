# Delivered Solution

## Overview
FeedMe was implemented as a multi-layered mobile application with a real cloud-hosted database.

The implemented architecture is:

Android App (Kotlin / Jetpack Compose) → Node.js Backend API → MySQL on Amazon RDS

## Implemented Features
The delivered prototype currently supports:

- welcome screen and user navigation
- home screen interface
- restaurant browsing
- restaurant detail navigation
- backend API integration
- cloud-hosted MySQL database
- sample production data retrieval from Amazon RDS

## Deployment Evidence
The system was tested successfully across all layers:

- Amazon RDS hosted the MySQL database
- MySQL Workbench connected successfully to the cloud database
- Node.js backend connected to Amazon RDS using environment variables
- browser testing confirmed the `/restaurants` API route returned live JSON data
- Android emulator successfully loaded restaurant data through the backend

## Result
This demonstrates that the FeedMe prototype is no longer using only hardcoded local restaurant data.  
Instead, the app now supports a real full-stack flow using a backend API and cloud database deployment.