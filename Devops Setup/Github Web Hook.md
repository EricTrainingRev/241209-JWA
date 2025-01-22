# Github Web Hook
Github and Jenkins can communicate with each other via web hooks: the process simplified is as follows:
- you push a change to the github repo
- github sends a POST request to your jenkins instance
- jenkins starts a job and clones your repo (specifically the updated branch)
- the job runs with the initial working directory within the cloned repo

In order to make this work you need to configure both Jenkins and Github

## Jenkins configuration
In your job you need to select "Git" in the Source Code Management section of the job (provided by the git plugin). In this configuration you will need to provide the clone url for your repo, and in the "branches to build" section you will need to provide identifiers for the branches that the job should work with. If you want any changes to trigger the job leave this section blank

Next go to Build Triggers and check the "GitHub hook trigger for GITScm polling"

Now finish creating your job to perform your desired automation.

## Github configuration
Go to the settings of your github repo and navigate to the "Webhooks" section. There should be a button that says "Add webhook", click this button. In the "Payload URL" section put the following url: `http://Jenkins-url/github-webhook/`. Finally, chose the trigger for the webhook (if you want pushes alone that should be the default option). Create the webhook, and then check the test ping succeeded. 

If the test ping fails there are a few common causes:
- github has not been given access to your cloud instance via security group rules. Allow the "hooks" IPs in [this](https://api.github.com/meta) collection to access the port Jenkins is running on
- make sure the url is correct: there needs to be a / after github-webhook
- Make sure the Jenkins url is correct: you can check it in your Jenkins system settings