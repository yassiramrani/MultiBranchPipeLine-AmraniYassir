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

Le programme affiche `Bonjour, DevOps !` sur `main`. La branche de démonstration change le message par défaut et adapte son test à `Bonjour, DevOps EMSI !`.

## Résultats vérifiés

Jenkins 2.528.2, Maven 3.9.11 et JDK 21, avec compilation ciblant Java 17. Les builds ont utilisé une copie locale des branches déjà publiées sur GitHub. Jenkins a archivé le JAR après les trois vérifications.

| Branche | Commit testé | Vérifications | Sortie du JAR | Jenkins |
| --- | --- | --- | --- | --- |
| `main` | `b1a431cb98ed` | 3/3 | `Bonjour, DevOps !` | SUCCESS |
| `feature/welcome-message` | `955499ace35a` | 3/3 | `Bonjour, DevOps EMSI !` | SUCCESS |

L’indexation a découvert les deux branches à partir de la source Git du laboratoire. La procédure GitHub/ngrok est dans [le guide webhook](webhook-ngrok.md). La livraison d’un événement webhook GitHub n’a pas été testée.

Voir [le compte rendu](RAPPORT.md).
