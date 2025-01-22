# Jenkins Email Setup
Jenkins has the ability to compose and send emails based upon triggering conditions in your Jobs. To configure these abilities you need to navigate to `Manage Jenkins` and then to `System`. Within this menu there are a few configurations to set. Note that only the core e-mail settings are configured here, but if you download the recommended plugins there will be an Extended E-mail Notification section where you can add more configurations of your choice:
- System Admin e-mail address
    - this lets you configure the "from" header of emails you send: this is typically the first thing people notice about an email (who is it from) so you should set it to something that indicates it is from Jenkins
    - example: `Jenkins Notification <email@email.com>`
- SMTP servier:
    - this is determined by the email service you are using, for training purposes I recommend making a gmail account that is expressly used by Jenkins
    - example for gmail: smtp.gmail.com
- Use SMTP Authentication (under Advanced)
    - this is where you provide the username and password for your email account Jenkins will use: to avoid issues with 2 factor authentication it is recommended to us an [App Password](https://support.google.com/accounts/answer/185833?hl=en) instead of the regular password
- Use SSL (under Advanced)
    - Jenkins is pre-configured to use SSL, so make sure to check this box
- SMTP Port
    - the gmail port for using SSL is 465, so set this value accordingly 

There is an option to test the configuration when you are done, an email should be sent to a location of your choice if everything was set successfully