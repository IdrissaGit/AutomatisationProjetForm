Feature: Contact form autom

Scenario: remplissage des champs obligatoires
    Given un utilisateur accède au formulaire de contact
    And saisit les champs obligatoires
    And selectionne le secteur de l'entreprise
    And accepte le traitement des données
    And clique sur le bouton envoyer 
    Then le message "Your submission has been received." s'affiche
    