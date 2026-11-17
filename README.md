# TP MultiBranch PipeLine

Yassir Amrani · EMSI Tanger · 5DDSIT G1

## Objectif

Construire et vérifier une application Java avec un pipeline Jenkins versionné. Le pipeline récupère le commit du job, compile l'application avec Maven, exécute les vérifications et archive le JAR.

## Exécution locale

Prérequis pour Maven et l'agent Jenkins : JDK 17 ou 21, Git et Maven 3.9.x. Les plugins Pipeline, Git et Timestamper sont nécessaires. Le TP Multibranch utilise aussi GitHub Branch Source.

```sh
mvn -B clean package
java -jar target/tp-multibranch.jar
```

## Configuration Jenkins

1. Créer le dépôt GitHub `MultiBranchPipeLine-AmraniYassir` et pousser `main` ainsi que `feature/welcome-message`. Le bundle fourni conserve les deux branches.
2. Dans Jenkins, créer un **Multibranch Pipeline**. Ajouter la source **GitHub**, sélectionner le dépôt, activer la découverte des branches et laisser `Jenkinsfile` comme chemin du script. Pour un dépôt privé, enregistrer les identifiants dans Jenkins.
3. Lancer **Scan Multibranch Pipeline Now**. Vérifier que `main` et `feature/welcome-message` apparaissent avec leur exécution respective. Le checkout récupère la révision associée à chaque exécution.
4. Suivre [la fiche webhook](webhook-ngrok.md) pour vérifier un déclenchement après push.
5. Ajouter les captures de la page des branches et des exécutions réelles au présent README, puis remettre le lien GitHub dans Classroom.

Le programme affiche `Bonjour, DevOps !` sur `main`. La branche de démonstration change le message par défaut et adapte son test à `Bonjour, DevOps EMSI !`.

## Résultats vérifiés

Compilation avec le compilateur Java 21 ciblant Java 17, trois vérifications et exécution du JAR. Les journaux du dossier `verification/` proviennent des commandes Java lancées localement. L’exécution Maven et les captures d’une exécution Jenkins restent à valider.

Voir [le compte rendu](RAPPORT.md).
