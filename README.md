Use case diagram

Use Case Diagrams depict the interactions between actors (users or external systems) and the AIS-R-Enhanced system, providing a high-level visual representation of the system's capabilities. These diagrams aid in identifying and defining the many use cases that the system must serve, as well as detailing the actions that users may take and how the system responds. Use Case Diagrams are an effective technique for collecting and comprehending system requirements from a user's perspective.

1.	Admin 
Manage Admin: Administrators can manage and supervise other administrative users in the system. Admins can examine, admin, or remove existing administrative user accounts, as well as grant or withdraw administrative privileges.

Add New Admin: Administrators can create new administrative users in the system. Administrators can establish a new administrative user account by entering the appropriate information (such as a username, password, and contact details).

2.	Management 
Manage Manager: Administrators can manage and supervise managerial users in the system. Administrators have the ability to examine, amend, or delete existing managerial user accounts, as well as assign or alter managerial duties and responsibilities.

Add New Manager: Administrators can create new management users in the system. Similar to adding new administrators, this use case allows administrators to provide the information required to create a new managerial user account, including assigning certain management duties.

3.	Recruit
Register: Recruits are able to register themselves in the system. Recruits fill out a registration form with their personal information, educational background, job experience, and other essential information for the recruiting process.

Update Profile: Recruits can change their profile information within the system. Recruits can change and update their profile information, such as contact information, qualifications, job positions, and preferences, to ensure that their profiles are current and correct.


<img width="587" alt="Screenshot 2024-05-29 at 3 13 44 pm" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/3743f723-4bdf-42d7-a6aa-1c974c64ffd1">




Class diagram


•	Class Diagrams are static representations of the AIS-R-Enhanced system's structure that show the numerous classes, properties, methods, and interactions between objects. These diagrams provide a comprehensive overview of the system's architecture, emphasising the essential components and their relationships. Class Diagrams help developers comprehend the system's architecture at a conceptual level by assisting in the identification of classes and their responsibilities, as well as the organisation of data and behaviour inside the system.

<img width="534" alt="Screenshot 2024-05-26 at 10 36 51 am" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/4ec7c6fe-f150-4cc0-9bfc-935462f5cfad">


ER diagram 

•	The Entity-Relationship Diagram (ERD) is vital for database architecture since it depicts the relationships between various entities in the AIS-R-Enhanced system. ERDs help to organise and manage data by visually showing the structure of the database schema, including entities, properties, and their relationships. ERDs aid in defining entity relationships such as one-to-one, one-to-many, and many-to-many, so assuring the database design's integrity and efficiency.
<img width="667" alt="Screenshot 2024-05-29 at 2 35 21 pm" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/3ef2aa10-9ba7-447b-baf5-7c613a37189b">


Sequence diarams

1. Admin

Sequence Diagrams depict behavioural models, which provide a thorough perspective of the dynamic behaviour of the AIS-R-Enhanced system. These diagrams depict the chain of interactions between various items in the system throughout time. Sequence Diagrams, which illustrate the flow of control and message transmission between objects, allow stakeholders to visualise the execution of certain functionality and understand how different components interact to complete tasks. They are very effective at simulating the logic and behaviour of complex system processes.

1.	Admin
•	The Admin user role interacts with the system to perform administrative functions such as adding new administrators, managing managers, and viewing/recruiting new applicants.
•	After logging in, the Admin submits a request to add a new administrator to the system.
•	The request is sent to the MultithreadServer, which then connects with DatabaseUtils to update the admin list in the database.
•	Similarly, the Admin may manage managers by adding or modifying their information, while the MultithreadServer facilitates communication with the DatabaseUtils.
•	Furthermore, the Admin may examine and recruit new applicants by accessing the recruit list, which is obtained from the database using the MultithreadServer and DatabaseUtils.


   <img width="781" alt="Screenshot 2024-05-29 at 2 35 49 pm" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/8bc25d79-c50e-45e6-895b-3d14855a3ecd">


2. Manager

•	The Manager uses the system to execute managerial activities including allocating recruits to departments and changing their responsibilities.
•	When the Manager logs in, the sends a request to recruiters to examine available prospects.
•	The MultithreadServer obtains the recruit list from DatabaseUtils and displays it to the Manager for review.
•	The Manager then picks a recruit and assigns them to a certain department by submitting an assignment request to the MultithreadServer.
•	The MultithreadServer then interacts with the DatabaseUtils to change the recruit's assignment status in the database.



<img width="754" alt="Screenshot 2024-05-29 at 2 36 14 pm" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/42dd2ff6-6218-43fe-9970-17d302d701a3">


3. Recruit

•	Recruits engage with the system by logging in to view their profile and submit/update their information.
•	After submitting login information, the Recruit initiates a login request to the MultithreadServer.
•	Upon successful login confirmation from the MultithreadServer, the Recruit can see or amend their profile data.
•	If the Recruit decides to update their profile, they submit a profile update request to the MultithreadServer, which updates the information in the database using the DatabaseUtils component.


   <img width="747" alt="Screenshot 2024-05-29 at 2 36 36 pm" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/bcc1a213-0943-40fd-9b2b-294c67f2ecf7">


Syetm architecture


<img width="377" alt="Screenshot 2024-05-29 at 5 54 00 pm" src="https://github.com/ManeeTutor/COIT20258_T1_2024_Assignment3/assets/127360529/b326e504-6f37-4920-bf72-31f252f52af4">
