# Called by Travis CI to push latest javadoc
# From http://benlimmer.com/2013/12/26/automatically-publish-javadoc-to-gh-pages-with-travis-ci/

PROJECT="catalyst"

if [ "$TRAVIS_REPO_SLUG" == "atomix/$PROJECT" ] && \
   [ "$TRAVIS_JDK_VERSION" == "oraclejdk8" ] && \
   [ "$TRAVIS_PULL_REQUEST" == "false" ] && \
   [ "$TRAVIS_BRANCH" == "master" ]; then
  echo -e "Publishing javadoc...\n"
  
  mvn javadoc:javadoc -Djv=latest
  TARGET="$(pwd)/target"

  cd $HOME
  git clone --quiet https://${GH_TOKEN}@github.com/atomix.github.io gh-pages > /dev/null
  
  cd gh-pages
  git config --global user.email "travis@travis-ci.org"
  git config --global user.name "travis-ci"
  git rm -rf $PROJECT/api/latest 
  mv ${TARGET}/site/apidocs/api/latest $PROJECT/api
  git add -A -f $PROJECT/api/latest
  git commit -m "Javadoc generated from $PROJECT travis build $TRAVIS_BUILD_NUMBER"
  git push -fq origin > /dev/null

  echo -e "Published Javadoc to atomix.github.io.\n"
fi
