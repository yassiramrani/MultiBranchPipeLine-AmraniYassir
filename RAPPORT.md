# Compte rendu · MultiBranch PipeLine

**Yassir Amrani · EMSI Tanger · DevOps 2026/2027**

Le TP automatise la compilation, les tests et le conditionnement d’un programme Java. Le programme accepte un nom facultatif, supprime les espaces en début et fin et utilise un nom par défaut si l’argument est absent ou vide.

| Étape | Vérification |
| --- | --- |
| Checkout | Le script récupère le commit associé au job et affiche son identifiant. |
| Build | Maven compile les classes en ciblant Java 17. |
| Test, package et exécution | Trois cas vérifient la valeur de retour. Si un cas échoue, le conditionnement s’arrête. Le JAR construit est ensuite exécuté et archivé. |

L’indexation doit découvrir les deux branches et le webhook doit relancer la branche modifiée lors d’un push. La branche de démonstration a sa propre sortie et ses propres attentes.

La compilation, les trois vérifications et le lancement du JAR ont été exécutés localement avec les outils Java. Les journaux correspondants sont dans `verification/`. La validation du job Jenkins et ses captures restent à réaliser.
