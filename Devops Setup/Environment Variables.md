# Environment Variables
any information you need access to but don't want to save in a public repo can be stored in environment variables. Jenkins allows you to create them within its UI, but you can also store them on your virtual machine. To make the persistent you will want to edit the .bashrc file on your virtual machine locted in your user directory (~ is a reference to your user directory). Use a file editor of your choice for this
```bash
vim ~/.bashrc
```
In the file add the following line somewhere, top or bottom of file should be fine
```bash
export ENVIRONMENT_VARIABLE_NAME="Value of the environment variable"
```
Save and exit: now anytime you connect to your instance the environment variable will be set. To apply the change right away run the following command:
```bash
sourc ~/.bashrc
```
note that if you have started Jenkins before setting the environment variable in your instance it may not have access to it, and you will need to restart Jenkins.