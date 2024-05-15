Readme du test automatisé sur la vérifiation du bon fonctionnement 
d'un formulaire de contact.

1) Le développement est fait par Eclipse IDE via un projet Maven
2) Il y a sur le formulaire une vérification contre les automates
   donc j'ai ajouter un timeout pour remplir la question.
3) D'autres scénarios peuvent s'ajouter à ce premier test 
   comme de vérifier que tous les champs requis sont bloquant.
   Ou encore de vérifier le format des champs de sorte qu'on ne 
   puisse pas faire de l'injection de code.
4) Pour exécuter le code il faut ouvrir et exécuter le code dans automRunner.java
   Run As --> JUnit Test
5) La définition des steps se trouve dans le package com.stepDefinitio
   le fichier RemplissageFormStepDef.java