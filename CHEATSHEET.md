# git

## repository actions

### clone
  * ```git clone https://git-codecommit.us-east-2.amazonaws.com/v1/repos/ftp72```

### reset

### fetch

  * `git fetch` -- update remote branches
  * `git fetch -p` -- update remote branches pruning branches deleted in server

## checkout/branch
   * `git branch` -- list local branches
   * `git branch -a` -- list local and remote branches
   * `git checkout [BranchName]` -- change to BranchName

## stash

   * `git stash list` -- list all stashes
   * `git stash push` -- push local workspace changes to stash
   * `git stash pop` -- pop local workspace changes from stash
   * `git stash drop` -- drop the latest stash

## file actions

  * Checkout a previous version
    * `git checkout <commit> <filename>`
  * Undo changes in staging
    * `git reset HEAD <filename>`
  * Discard changes in workspace
    * `git checkout -- <filename>`

## development cycle

### Clean up before starting

   * `git status` -- you should be on 'master' branch; and it should not show any files changed/staged etc
>       On branch master
>       Your branch is up-to-date with 'origin/master'.
>       nothing to commit, working tree clean
   * `git branch` -- it should not show any local branches
   * `git stash list` -- no stashes should be there
   * `git pull` -- get the latest master
     
### Create a branch

   * `git checkout -b [BranchName]`
      * See STANDARDS_AND_GUIDELINES.md for branch naming guidelines

### EDIT: Edit files as needed

### Periodically, add the file to staging area

   * `git status`
   * `git add -i` and 2/4 options to add changed/new files to staging area
      * Enter the number against the file to add the file to the staging area in the submenu
   * `git status`
   * go to EDIT, if there are more changes

### Commit it to the branch
   
   * `git commit -m [message]`
   * `git status`

### Absorb any changes that has been done to master since we branched

   * `git checkout master`
   * `git pull`
   * `git checkout [BranchName]`
   * `git rebase -i master`
      * If there are any conflicts between your changes and changes done in master, they will appear now. You need to go through the changes one by one, and resolve the conflicts.
      * Typically
         * pick all the changes i.e., `:wq` in the vi editor
         * If there is a conflict
            * For all files in conflict
               * Merge the conflicts highlighted with `<<<` and `>>>` markers
               * 'git add [FileInConflict]`
            * git rebase --continue

### Push it to origin

   * `git status` -- and check if you are on branch and not on 'master'
   * `git push -u origin HEAD`
      * At times, this fails with 'non-fast-forward' message. In that case
         * `git pull` and then try pushing
         * if confident, `git push --force origin HEAD` to force push the changes

### Create a pull request and get it merged
   * A pull request is the primary way you and other repository users can review, comment on, and merge code changes from one branch to another. You can use pull requests to collaboratively review code changes for minor changes or fixes, major feature additions, or new versions of your released software. 

   * In your browser, go to "https://635681506020.signin.aws.amazon.com/console" and select the repositoty and then click  "pull requests" link 

   * select desination branch and source branch (pull requst branch) and click compare button 
   * If any change is required, the reviewer add comments and save
   * The reviewer will merge the pull request by clicking "merge" button when the reviewer is satitifed completely 
   
   * Refer the URL for more details  https://docs.aws.amazon.com/codecommit/latest/userguide/pull-requests.html

### Clean up
   
   * `git checkout master`
   * `git fetch -p` -- if the reviewer has deleted the branch as s/he should, then you should see that your tracking branch also gets deleted by this command
   * `git pull`
   * `git branch` -- list all branches; the local branch will be there
   * `git branch -d [BranchName]`
   * `git branch` -- list all branches; the local branch will not be there

# maven

## check style
  * ```mvn -Dcheckstyle.consoleOutput=true checkstyle:check```
  * ```mvn checkstyle:checkstyle```
  * ```open target/site/checkstyle.html```

## run cli
  * ```mvn exec:java -Dexec.mainClass=com.hexaware.ftp72.util.CliMain```

## running a single test
  * ```mvn -Dtest=[TestClass#testname] test```

## Package
  * ```mvn package```

# tomcat

## Start/monitor logs

  * ```cd /path/to/apache-tomcat-9.0.0.M22```
  * ```rm -rf logs/*```
  * ```./bin/startup.sh```
  * ```tail -f logs/*```

## Deploy

  * Copy the war file to the webapps folder
    * ```cp target/<some>.war /path/to/apache-tomcat-9.0.0.M22/webapps/ftp72.war```

## Curl
  * `curl http://localhost:8080/ftp72/api/employees`
  * `curl http://localhost:8080/ftp72/api/employees/1000`

# angular

  * To serve from the working directory
    * ng serve --open
  * Build
    * ng build
  * Unit Test
    * ng test
    * npm test
  * Lint/Style check
    * ng lint --type-check
  * Generate new component
    * ng g component components/{name}
  * Generate new service
    * ng g service services/{name}


# Angular/Augury

  * ng is the angular instance
  * ng.probe($0).componentInstance where $0 is the selected component in the Elements tab