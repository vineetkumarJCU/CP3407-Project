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

<img width="940" height="268" alt="image" src="https://github.com/user-attachments/assets/7c556c48-0bee-4bfd-a2db-36dcc6ea9d42" />

<img width="940" height="1082" alt="image" src="https://github.com/user-attachments/assets/38277264-a781-4a07-a7af-0e791185842c" />
  
