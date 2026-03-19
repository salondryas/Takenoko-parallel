# MyTakenoko 🐼🎋

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

**MyTakenoko** est une implémentation logicielle en Java du célèbre jeu de plateau *Takenoko*. Ce projet simule le moteur de jeu complet et intègre plusieurs intelligences artificielles (Bots) capables de jouer de manière autonome selon différentes stratégies.

Ce projet a été réalisé dans le cadre de notre cursus à **Polytech Nice Sophia** (Université Côte d'Azur).

## 📋 Table des matières
- [Fonctionnalités](#-fonctionnalités)
- [Architecture du projet](#-architecture-du-projet)
- [Prérequis](#-prérequis)
- [Installation et Compilation](#-installation-et-compilation)
- [Exécution](#-exécution)
- [Statistiques et Simulations](#-statistiques-et-simulations)
- [Auteurs](#-auteurs)

## ✨ Fonctionnalités

- **Moteur de jeu complet** : Implémentation fidèle des règles de Takenoko (plateau hexagonal, gestion de la météo, croissance des bambous, pose des canaux d'irrigation et aménagements).
- **Entités autonomes** : Déplacement interactif du Panda et du Jardinier.
- **Système d'objectifs** : Gestion des cartes objectifs (Parcelles, Panda, Jardinier) et de la carte Empereur.
- **Intelligences Artificielles (Bots)** : Plusieurs profils de joueurs virtuels dotés de stratégies variées :
  - *Bot Aléatoire* : Joue des coups au hasard.
  - *Bot Panda / Jardinier* : Se concentre spécifiquement sur un type d'objectif.
  - *Bot Sabotage* : Tente de bloquer les adversaires.
  - *Bot Équipe* : Stratégie de coopération/optimisation avancée.
- **Moteur de simulation** : Possibilité de lancer des milliers de parties à la suite pour évaluer l'efficacité des différentes stratégies.

## 🏗 Architecture du projet

Le code source est organisé pour séparer la logique de jeu de l'intelligence artificielle :

* `fr.cotedazur.univ.polytech.startingpoint` : Cœur de l'application (`GameEngine`, `GameState`).
  * `/actions` : Logique des différentes actions jouables (déplacements, pioche, pose...).
  * `/elements` : Composants du jeu (Aménagements, Tuiles, Panda, Jardinier, Plateau).
  * `/joueurs` : Définition des Bots et de l'inventaire. Contient le sous-package `Strategies`.
  * `/objectifs` : Gestion de tous les types de cartes objectifs.
  * `/weather` : Gestion du dé météo et de ses effets.
  * `/utilitaires` : Outils de positionnement 3D (coordonnées axiales), affichage console et logs.

## 🛠 Prérequis

Pour compiler et exécuter ce projet, vous aurez besoin de :
- **Java JDK** (version 11 ou supérieure recommandée)
- **Maven** (pour la gestion des dépendances et le build)

## 🚀 Installation et Compilation

1. Clonez le dépôt sur votre machine locale :
   ```bash
   git clone [https://github.com/](https://github.com/)[votre-nom-d-utilisateur]/mytakenoko.git
   cd mytakenoko
