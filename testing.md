# Testing

## Overview
Testing for FeedMe focused on verifying that the implemented features from each iteration behaved correctly, matched the relevant user stories, and remained stable after UI and navigation changes. Testing was primarily carried out through iterative manual execution in Android Studio using the emulator, followed by regression checks after each major screen or workflow update.

The main goal of testing was to confirm that delivered functionality worked as expected across the customer flow, vendor flow, admin flow, and settings/personalisation features. Testing also checked whether state changes were reflected correctly in the interface, especially where global in-memory state was used through `AppState` and shared settings were used through `FeedMeSettings`.

---

## Testing Approach

### 1. Functional testing
Functional testing was used to confirm that each implemented feature performed its intended task. This included navigation, button actions, data display, state updates, and user workflow completion.

### 2. Acceptance testing
Acceptance testing was used to compare implemented screens and behaviour against the relevant user stories and acceptance criteria. This was especially important for:
- vendor menu management
- admin approval
- sustainability score display
- saved restaurants
- order persistence
- checkout and tracking
- settings and personalisation

### 3. Regression testing
Regression testing was performed after changes to shared navigation and reusable UI elements. This was necessary because changes such as adding a universal top bar and updating navigation routes could unintentionally break existing screens.

### 4. UI testing
UI testing focused on layout consistency, navigation clarity, readability, and whether screens remained usable after design updates such as:
- universal back button integration
- shared orange theme
- settings customisation
- dashboard/sidebar updates
- card-based layouts for restaurants, orders, and saved items

---

## Test Environment

- **IDE:** Android Studio
- **Language:** Kotlin
- **UI framework:** Jetpack Compose
- **Test platform:** Android Emulator
- **Navigation:** Compose Navigation
- **State sources tested:** `AppState`, `FeedMeSettings`
- **Build verification:** project rebuild and rerun after major file updates

---

## Features Tested by Iteration

## Iteration 1 testing
Iteration 1 focused on establishing the main customer-facing structure of the app.

### Features tested
- welcome screen navigation
- login and register screen navigation
- home screen layout
- restaurant browsing flow
- checkout route navigation
- base settings screen access

### Results
These features were tested to confirm that the core multi-screen application flow worked without crashes and that navigation between pages was functioning before more advanced features were added.

---

## Iteration 2 testing
Iteration 2 focused on extending the application to include more realistic business, admin, persistence, and customer engagement features.

### Features tested
- vendor dashboard
- menu item creation
- menu item deletion
- admin approval workflow
- sustainability screen
- sustainability score shown on restaurant cards
- saved restaurants workflow
- orders workflow
- checkout persistence
- delivery address editing
- order tracking progression
- settings customisation
- universal top bar / back navigation
- explore page navigation consistency

### Results
This iteration required more extensive regression testing because multiple shared components and flows were updated.

---

## Acceptance Testing by Feature

## Customer features

### Saved restaurants
**Purpose:** verify that restaurants can be saved and later viewed in the Saved screen.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| SAV-01 | User opens Explore page | Restaurant list is displayed | Pass |
| SAV-02 | User presses **Save Restaurant** on a restaurant | Restaurant is added to saved list | Pass |
| SAV-03 | User opens Saved screen | Previously saved restaurant is displayed | Pass |
| SAV-04 | User presses **Remove** on a saved restaurant | Restaurant is removed from saved list | Pass |
| SAV-05 | No restaurants saved | Empty-state message is shown | Pass |

### Orders and checkout
**Purpose:** verify that placed orders are stored and displayed in Orders.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| ORD-01 | User opens checkout | Checkout screen displays total and address | Pass |
| ORD-02 | User edits delivery address | Updated address is shown in checkout | Pass |
| ORD-03 | User enters customer details and presses **Place Order** | Order is added to `AppState.orders` | Pass |
| ORD-04 | User opens Orders screen after placing order | Order appears in list | Pass |
| ORD-05 | No orders placed | Empty-state message is shown | Pass |

### Order tracking
**Purpose:** verify that tracking status updates dynamically and ETA is shown.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| TRK-01 | User places an order and opens tracking | Tracking screen opens successfully | Pass |
| TRK-02 | Screen starts at **Order Placed** | Initial state is correct | Pass |
| TRK-03 | Timer progresses | Status updates through Preparing, Out for Delivery, Delivered | Pass |
| TRK-04 | Current step is active | Current and previous steps are visually highlighted | Pass |
| TRK-05 | ETA text is displayed | Estimated delivery time is visible | Pass |

### Explore / restaurant listing
**Purpose:** verify restaurant browsing works consistently and includes sustainability information.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| EXP-01 | User opens Explore page | Restaurant list is displayed | Pass |
| EXP-02 | Restaurant card displays rating and delivery fee | Key information is visible | Pass |
| EXP-03 | Restaurant card displays sustainability score | Eco score is visible in listing | Pass |
| EXP-04 | User presses **View Details** | Detail navigation works | Pass |
| EXP-05 | Explore page top bar back button works | User returns correctly | Pass |

---

## Vendor features

### Vendor menu management
**Purpose:** verify that vendor can add and remove menu items from the dashboard.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| VEN-01 | Vendor opens dashboard | Vendor dashboard loads | Pass |
| VEN-02 | Vendor adds valid menu item name and price | Item appears in menu list | Pass |
| VEN-03 | Vendor leaves fields blank and presses add | Invalid blank item is not meaningfully added | Pass |
| VEN-04 | Vendor deletes existing item | Item is removed from list | Pass |
| VEN-05 | Analytics card remains visible after CRUD actions | Dashboard layout remains stable | Pass |

### Vendor analytics
**Purpose:** verify analytics information is displayed.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| VAN-01 | Vendor opens dashboard | Analytics section is visible | Pass |
| VAN-02 | Total orders displayed | Metric visible | Pass |
| VAN-03 | Revenue displayed | Metric visible | Pass |
| VAN-04 | Top item displayed | Metric visible | Pass |

---

## Admin features

### Vendor approval
**Purpose:** verify admin can approve and reject vendors.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| ADM-01 | Admin opens approval screen | Pending vendors are listed | Pass |
| ADM-02 | Admin presses **Approve** | Status changes to Approved | Pass |
| ADM-03 | Admin presses **Reject** | Status changes to Rejected | Pass |
| ADM-04 | Multiple vendors updated | Each vendor retains its own updated status | Pass |

---

## Sustainability features

### Sustainability score
**Purpose:** verify sustainability is visible both as a dedicated feature and within restaurant browsing.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| ECO-01 | User opens sustainability screen | Sustainability metrics are displayed | Pass |
| ECO-02 | Overall score is shown | Numerical summary is visible | Pass |
| ECO-03 | Score guide is shown | Score ranges are explained | Pass |
| ECO-04 | User opens restaurant listing | Eco score appears on restaurant cards | Pass |

---

## Settings and personalisation

### Settings
**Purpose:** verify shared settings can be changed and reflected in the app.

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| SET-01 | User opens settings | Settings screen loads without errors | Pass |
| SET-02 | User toggles dark mode | Theme mode changes | Pass |
| SET-03 | User changes accent colour | Accent updates correctly | Pass |
| SET-04 | User opens Saved from settings | Navigation works | Pass |
| SET-05 | User opens Orders from settings | Navigation works | Pass |
| SET-06 | User presses reset | Settings values return to defaults | Pass |

---

## Navigation and shared UI testing

### Universal top bar
A reusable `FeedMeTopBar` component was introduced and then tested across updated screens.

### Screens tested with top bar
- settings
- saved
- orders
- checkout
- order tracking
- explore
- vendor dashboard
- admin approval
- sustainability

| Test ID | Scenario | Expected Result | Result |
|---|---|---|---|
| NAV-01 | Screen opens | Top bar is visible | Pass |
| NAV-02 | Back button pressed | Returns to previous screen | Pass |
| NAV-03 | Top bar added after existing screen logic | Original screen content still visible | Pass |

---

## Regression Testing Performed

Regression testing was carried out after the following updates:

### After adding universal top bar
The following were retested:
- saved
- orders
- checkout
- order tracking
- settings
- explore
- vendor dashboard
- admin approval
- sustainability

This was necessary to ensure:
- no missing helper composables
- no unresolved references
- no broken navigation due to new `NavController` parameters

### After adding saved restaurant logic
The following were retested:
- explore page
- saved page
- remove saved item behaviour

### After adding order persistence
The following were retested:
- checkout
- tracking
- orders page

### After updating settings screen
The following were retested:
- dark mode
- accent colour selection
- reset settings
- shortcut links to saved and orders

---

## Defects Found and Fixed

### 1. Advanced pages existed but were not visible
**Issue:** Vendor, Admin, and Sustainability routes were created but not accessible from the UI.  
**Fix:** Added explicit sidebar menu buttons in `HomeScreen`.

### 2. Checkout screen signature mismatch
**Issue:** Navigation used a newer checkout function signature while the screen still used the older version.  
**Fix:** Replaced checkout implementation so parameters matched navigation calls.

### 3. Helper composables missing after screen upgrades
**Issue:** Some upgraded screens referenced helper functions not included in the file, causing unresolved reference errors.  
**Fix:** Added missing helper composables directly to the corresponding file.

### 4. Saved page remained empty
**Issue:** `SavedScreen` displayed correctly, but no workflow was adding items to `AppState.savedRestaurants`.  
**Fix:** Added save logic in `RestaurantListScreen`.

### 5. Orders page remained empty
**Issue:** Checkout navigated to tracking without persisting any order to `AppState.orders`.  
**Fix:** Added order creation logic before tracking navigation.

### 6. Explore page used missing shared data source
**Issue:** Explore screen referenced restaurant data not available in `AppState`.  
**Fix:** Replaced with a local restaurant list consistent with the current project structure.

### 7. Navigation inconsistency
**Issue:** Some screens relied on phone back behaviour while others used in-app controls.  
**Fix:** Introduced reusable top bar with a universal in-app back button.

---

## Limitations of Current Testing
The testing completed for this project was focused on implemented behaviour in the current prototype and was mainly performed manually. The following areas remain opportunities for future technical improvement:
- automated unit testing
- API integration tests
- persistent database-backed tracking updates
- broader edge-case validation
- device-specific responsiveness testing on a wider range of screen sizes

These improvements would strengthen the testing strategy further in later iterations or future releases.

---

## Conclusion
Testing confirmed that the implemented FeedMe prototype delivers the major customer, vendor, admin, and sustainability workflows completed during the project iterations. The most important tested behaviours were:
- saving restaurants
- placing and viewing orders
- editing address during checkout
- tracking order progress
- vendor menu management
- admin approval decisions
- sustainability score visibility
- settings customisation
- reusable back navigation across screens

The final result is a working multi-screen prototype in which the delivered implementation matches the functionality completed during the iterations and remains stable after repeated UI and navigation changes.
