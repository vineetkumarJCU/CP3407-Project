
How to edit this: test-2025
* Option-1 (tested and worked ok): PyCharm supports editing of these .md files. Then you need to push to the main branch or make a pull request.
* Option-2 (tested ok): Edit and commit it directly on github. Then any local repo copies will need to be "updated".

# CP3407 Project

This a project assignment template for CP3407. 
The following is the list of items, which are required to be completed.

## How to submit [You may delete this before submitting]

2. Add your instructor (JCU-Australia: jc138691@gmail.com Dmitry Konovalov) as a team member to view your project on github
1. Submit link to your repository
2. Download your github repository as a zip file and submit via LearnJCU.

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

Frontend: React
Backend: Node.js + Express
Database: MySQL
Deployment (later stage): AWS

The decision was based on:

* Scalability
* Modern web practices
* Cloud compatibility
* Team familiarity

---



## Iteration 1 [duration 3-4 weeks], add your start and end dates 

* Goal is to have 2 iterations during a trimester of teaching.
* Update the following during each week prac session
* During pracs, you may experiment with using other github ways of tracking changes, e.g. via pull requests.

1. [user story title](./user_stories/user_story_01_title.md), priority XX, YY days 
2. ...

Total: YY days


### Iteration 2 [duration 3-4 weeks], add your start and end dates
Goal is to have 2 iterations during a trimester of teaching.
1. [user story title](./user_stories/user_story_01_title.md), priority XX, YY days 
2. ...

Total: YY days

### Not enough time/developers: 
1. [user story title](./user_stories/user_story_01_title.md), priority XX, YY days 
2. ...

Total: YY days

# Actual iterations
1. [Iteration-1](./iteration_1.md)

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
- Implemented user authentication screens for sign up and login
- Built the restaurant browsing screen to display restaurant data
- Developed a restaurant details screen to support future menu and ordering features
Not Completed / Moved Forward
- Full place-order functionality was not completed in Iteration 1
- Cart and checkout logic required additional data modelling and UI integration
- Advanced visual polish was postponed to the next iteration

Reflection
Iteration 1 focused on creating a working Android prototype with core navigation, user access, and restaurant browsing. This provided a strong foundation for future development and reduced technical risk early in the project. Although place-order functionality was originally planned, it was deferred because additional work was required to connect menu selection, cart state, and database updates. The team prioritised delivering stable working software at the end of the iteration, which is consistent with an agile and iterative development process.


<img width="294" height="649" alt="Page 3" src="https://github.com/user-attachments/assets/6b273830-adbe-4e3d-a71b-8c14275fe163" />
<img width="293" height="649" alt="Page 2" src="https://github.com/user-attachments/assets/489b36c9-0d42-4e2a-acdd-e4377ab348f3" />
<img width="292" height="650" alt="Page 1" src="https://github.com/user-attachments/assets/317d5e88-82e0-449a-8b30-fe93d1054421" />
<img width="293" height="650" alt="Page 4" src="https://github.com/user-attachments/assets/792273a8-cf30-4647-ac8b-e2b25d5362ec" />
<img width="295" height="651" alt="Page 5" src="https://github.com/user-attachments/assets/d12c6f55-1c30-4180-a059-d8e9bc0c51c4" />
<img width="293" height="655" alt="Page 6" src="https://github.com/user-attachments/assets/e6c3ae34-132a-4208-b0a2-ab8a0e8c6425" />






2. [Iteration-2](./iteration_2.md)


