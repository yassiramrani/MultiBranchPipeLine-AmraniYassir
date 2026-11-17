# TP · GitHub webhook et ngrok

1. Vérifier que l’instance Jenkins de TP utilise l’authentification et a chargé **GitHub** et **GitHub Branch Source**.
2. Ouvrir un tunnel temporaire sur le port de cette instance de TP depuis une machine disposant de ngrok. Configurer l’authentification ngrok avec le compte du labo et conserver le jeton en dehors du dépôt.
3. Dans **Settings → Webhooks → Add webhook** du dépôt GitHub, utiliser l’URL HTTPS fournie par ngrok suivie de `/github-webhook/`, un contenu `application/json` et l’événement **push**. Configurer le même secret de webhook dans GitHub et dans le plugin Jenkins. Garder ce secret hors des scripts, rapports et captures.
4. Créer le job Multibranch avec la source GitHub. Lancer un scan, puis pousser un commit sur une branche découverte. Contrôler la livraison dans **Recent Deliveries** et vérifier le SHA du commit dans la console du job de la branche.
5. Relever la date, le SHA, le résultat HTTP et le lien du build. Capturer la livraison et l’exécution, puis fermer le tunnel de démonstration.

Aucun tunnel ni webhook actif n’a été créé pendant cette préparation. Le résultat doit être vérifié après connexion au Jenkins du labo.
