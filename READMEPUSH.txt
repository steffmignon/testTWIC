Lancer la VM de virtual BOX

Pour lancer JENKINS : 
ssh eseo@127.0.0.1 -p 1022
cd ~/Projet/Jenkins
java -jar jenkins.war &

Pour lancer sonar :
ssh eseo@127.0.0.1 -p 1022
cd ~/Projet/Sonar/sonarqube-7.9.5/bin/linux-x86-64
./sonar.sh start

Pour lancer le relay :
ssh eseo@127.0.0.1 -p 1022
cd Projet/configs/
sudo relay login -k 5a08b4a7-62d5-402c-81b4-d96cc793118f -s eezB9No9Thzw
relay forward --bucket github-jenkins http://localhost:18080/github-webhook/


Token Sonarqube (Stéphane):
29deb7b678f87750c0bc9bd5445d85ba2ea4a9ce
Pour lancer sonarqube :
lancer un terminal depuis le fichier ESEO_API_REST
mvn sonar:sonar \ -Dsonar.projectKey=TestTWIC \ -Dsonar.host.url=http://localhost:9000 \ -Dsonar.login=29deb7b678f87750c0bc9bd5445d85ba2ea4a9ce


Pour push sur le git :
copier les fichiers
les coller dans :
C:\Users\steph\Documents\I2\Option LD\TWIC\ESEO_API_Rest\gitCode\testTWIC
faire un git bash dans :
C:\Users\steph\Documents\I2\Option LD\TWIC\ESEO_API_Rest\gitCode\testTWIC

Et faire les commandes classiques


Token WebHook relay :

key :
5a08b4a7-62d5-402c-81b4-d96cc793118f
secret :
eezB9No9Thzw
To configure relay CLI, run the following command: 
relay login -k 5a08b4a7-62d5-402c-81b4-d96cc793118f -s eezB9No9Thzw

To use credentials as an environment variables: 
export RELAY_KEY=5a08b4a7-62d5-402c-81b4-d96cc793118f
export RELAY_SECRET=eezB9No9Thzw

To create Kubernetes Secret: 
kubectl create secret generic whr-credentials \
    --from-literal=key=5a08b4a7-62d5-402c-81b4-d96cc793118f \
    --from-literal=secret=eezB9No9Thzw

