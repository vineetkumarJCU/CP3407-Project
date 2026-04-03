## Database Setup Summary

The FeedMe project uses a cloud-hosted MySQL database on Amazon RDS.

The setup process included:

1. creating a MySQL database instance in Amazon RDS
2. configuring AWS security rules for MySQL access
3. connecting to the hosted database using MySQL Workbench
4. creating the FeedMe relational schema
5. inserting sample restaurant data
6. connecting a Node.js backend API to the hosted database
7. connecting the Android app to the backend API using Retrofit

This allowed the Android application to retrieve live restaurant data from the cloud database rather than relying only on hardcoded local demo data.