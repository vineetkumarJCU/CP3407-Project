# CP3407 Project

This a project assignment template for CP3407. 
The following is the list of items, which are required to be completed.

## Team

1. Vineet Kumar
2. Brennen Caruana
3. Kirubanithi Sornamoorthy

# FeedMe – Intelligent Food Delivery Platform

CP3407 Software Engineering Project

FeedMe is a cloud-based food delivery platform designed to improve on FoodPanda by offering:

- Transparent delivery pricing
- Smart restaurant matching
- Sustainability scoring
- Vendor analytics dashboard

This project follows an iterative development approach as described in Chapter 1 of the textbook. Each iteration delivers working software and incorporates customer feedback.


# Project planning BEFORE iteration-1, (see chapters 1-3)

## 1. Initial Idea Discussion (Week 1)

During Week 1, we formed the group through messenger app. First we introduced each other. Then, the team discussed the project brief and analysed existing food delivery platforms such as FoodPanda and Uber Eats.

We identified the following common issues:

* Hidden delivery fees
* Poor transparency of pricing
* Limited tools for small vendors
* No sustainability information

From this discussion, we defined our Unique Selling Proposition (USP):

* Transparent pricing breakdown
* Smart restaurant matching
* Sustainability scoring
* Vendor analytics dashboard

At this stage, no coding was done. We focused only on understanding “what is needed”, following the principle that software development should not be guesswork .

---

## 2. Requirement Identification (Week 1)

We converted the project idea into user-focused requirements.

We identified three main user roles:

* Customer
* Vendor
* Admin

We then created high-level features required for each role.


## 3. Product Backlog Creation (Week 2)



In Week 2, we created a prioritised backlog of features.

We estimated each feature in developer days and assigned priorities (40 = highest priority).

| Feature                | Priority | Estimate (Days) |
| ---------------------- | -------- | --------------- |
| User Authentication    | 10       | 3               |
| Browse Restaurants     | 10       | 4               |
| Place Order            | 10       | 5               |
| Transparent Pricing    | 20       | 3               |
| Vendor Menu Management | 20       | 4               |
| Order Tracking         | 20       | 3               |
| Reviews & Ratings      | 30       | 2               |
| Vendor Analytics       | 30       | 5               |
| Admin Approval         | 40       | 3               |

Total Estimated Effort: 32 days

This allowed us to balance scope and time, ensuring the project could realistically be completed within the trimester.

Priority Justification

Priorities were assigned based on business value and system dependency:

Priority 10 (highest): Core features required for system operation (authentication, browsing, ordering)
Priority 20: Supporting features that improve usability
Priority 30: Features that enhance user experience
Priority 40 (lowest): Admin functionality implemented later

This ensures essential features are delivered first, reducing risk and enabling early testing.
---

**4. Project Capacity and Feasibility
**
Team Size: 3 developers


Burndown Chart (Iteration 1)

The burndown chart shows the remaining work over time:

Week 4: 20 days remaining
Week 3: 12 days remaining
Week 2: 5 days remaining
Week 1: 0 days remaining

This demonstrates steady progress and effective iteration management.



Assumed Velocity:
Each developer can complete ~15 days of work per iteration.

Total Capacity:
3 × 15 = 45 days

Total Work:
32 days

Feasibility:
The workload fits within team capacity, leaving buffer for testing and issues.

Conclusion:
The project is achievable on time and within budget.


## 4. Iteration Planning (Week 2)

Following the iterative approach described in Chapter 1, we structured development into iterations of approximately 20 working days .

### Iteration 1 Time and Idea (Weeks 3–4)

Focus: Core platform functionality

* User Authentication
* Browse Restaurants
* Basic UI Framework

### Iteration 2 Time and Idea (Weeks 5–7)

Focus: Order and vendor functionality

* Place Order
* Transparent Pricing
* Vendor Menu Management
* Order Tracking

Lower priority features were scheduled for later iterations or buffer time.

---

## 5. Risk Identification

Before starting development, we identified potential risks:

* Underestimating development time
* Integration issues between frontend and backend
* Database design errors
* Scope creep

To mitigate these risks, we decided:

* Each iteration must produce working software
* Testing will occur during each iteration
* Features may be reprioritised if necessary

This aligns with the principle that iteration helps manage change and keeps the project aligned with customer expectations .

---

## 6. Development Approach

We selected:

Frontend: Android application built using Kotlin and Jetpack Compose
Repository Layer: DataRepository for application logic and prototype data handling
Backend (planned production): Node.js + Express
Database (planned production): MySQL hosted on Amazon RDS
Deployment (planned production): AWS EC2 + Amazon RDS

The decision was based on:

* Scalability
* Modern web practices
* Cloud compatibility
* Team familiarity

---

Planned Iterations
Iteration 1 (10 February 2026 – 24 February 2026)

Goal: Deliver the initial Android application structure and core customer browsing functionality.

Planned user stories:

User Authentication, priority 10, 3 days
Browse Restaurants, priority 10, 4 days
Basic UI Framework, priority 10, 3 days
Restaurant Details, priority 20, 2 days

Total: 12 days

Iteration 2 (25 February 2026 – 17 March 2026)

Goal: Implement ordering, pricing, and vendor-side functionality.

Planned user stories:

Place Order, priority 10, 5 days
Transparent Pricing, priority 20, 3 days
Vendor Menu Management, priority 20, 4 days
Order Tracking, priority 20, 3 days

Total: 15 days

Deferred / Future Iteration

Features planned for future enhancement:

Reviews & Ratings, priority 30, 2 days
Vendor Analytics, priority 30, 5 days
Admin Approval, priority 40, 3 days

Total: 10 days

# Actual iterations
1. [Iteration-1](database SQL/Iterations/iteration_1.md)

Actual Iterations

Actual Iteration 1
Duration: Weeks 3–4  
Goal: Deliver the initial Android application structure and core customer browsing experience.
Planned
- User Authentication
- Browse Restaurants
- Basic UI Framework
- Place Order
Completed
- Set up the FeedMe Android project in Android Studio using Kotlin
- Designed the core user interface using Jetpack Compose
- Created navigation between major screens such as login, register, home, and restaurant list
- Built the restaurant browsing screen to display restaurant data
- Authentication flow (login and register)
- Developed a restaurant details screen to support future menu and ordering features
Not Completed / Moved Forward
- Full place-order functionality was not completed in Iteration 1
- Cart and checkout logic required additional data modelling and UI integration
- Advanced visual polish was postponed to the next iteration

Reflection
Iteration 1 focused on creating a working Android prototype with core navigation, user access, and restaurant browsing. This provided a strong foundation for future development and reduced technical risk early in the project. Although place-order functionality was originally planned, it was deferred because additional work was required to connect menu selection, cart state, and database updates. The team prioritised delivering stable working software at the end of the iteration, which is consistent with an agile and iterative development process.

Client Feedback (Iteration 1)

Positive:

Clean UI
Easy navigation

Improvements:

Add cart functionality
Improve performance

Action:
Added to Iteration 2 backlog.

<img width="294" height="649" alt="Page 3" src="https://github.com/user-attachments/assets/6b273830-adbe-4e3d-a71b-8c14275fe163" />
<img width="293" height="649" alt="Page 2" src="https://github.com/user-attachments/assets/489b36c9-0d42-4e2a-acdd-e4377ab348f3" />
<img width="292" height="650" alt="Page 1" src="https://github.com/user-attachments/assets/317d5e88-82e0-449a-8b30-fe93d1054421" />
<img width="293" height="650" alt="Page 4" src="https://github.com/user-attachments/assets/792273a8-cf30-4647-ac8b-e2b25d5362ec" />
<img width="295" height="651" alt="Page 5" src="https://github.com/user-attachments/assets/d12c6f55-1c30-4180-a059-d8e9bc0c51c4" />
<img width="293" height="655" alt="Page 6" src="https://github.com/user-attachments/assets/e6c3ae34-132a-4208-b0a2-ab8a0e8c6425" />


Project Documentation

Design
Testing
Tools

Deployment

The system is designed for cloud deployment using modern infrastructure:

Planned production deployment:

Backend hosted on AWS EC2
Database hosted on Amazon RDS using MySQL
Android application connected through backend API

Current prototype:

Android application tested on physical devices and emulator
DataRepository used for local simulation of application behaviour

This deployment plan ensures scalability, security, and future production readiness.


2. [Iteration-2](database SQL/Iterations/iteration_2.md)
# Actual Iteration 2

## Duration

30th March 2026 - end date to be finalised when finished

## Goal

Complete authentication, ordering workflow, pricing transparency, and UI refinements.

## Planned

* Authentication flow
* Place Order
* Transparent Pricing
* Vendor Menu Management
* Order Tracking
* Cart / Checkout integration
* UI improvements from client feedback

## Completed

* Implemented authentication flow for login and register screens
* Added user validation and state management
* Implemented cart and checkout workflow
* Added order placement functionality
* Added transparent pricing breakdown
* Improved restaurant details screen
* Refined UI layout and navigation flow
* Improved loading speed and state handling

## Not Completed / Moved Forward

* Vendor analytics dashboard
* Admin approval workflow
* Review and rating system
* Order history

## Reflection

Iteration 2 focused on completing the customer journey from authentication through checkout.

Moving authentication from Iteration 1 into Iteration 2 was necessary because the team prioritised establishing stable navigation and screen structure first.

This improved scope control and allowed the authentication flow to be implemented more reliably alongside checkout and pricing functionality.

## Client Feedback (Iteration 2)

Positive:

* Login and register flow works smoothly
* Checkout feels realistic
* Pricing transparency is clear

Requested improvements:

* Add order history
* Add review system
* Add vendor dashboard

Action:
Added to future backlog.



