-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Jeu 28 Avril 2016 à 14:21
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `filelec`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_famille` int(11) NOT NULL,
  `id_sous_famille` int(11) NOT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `code_article` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `prix_unitaire` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_articles_code_article` (`code_article`),
  KEY `IX_articles_id_famille` (`id_famille`),
  KEY `IX_articles_id_sous_famille` (`id_sous_famille`),
  KEY `IX_articles_nom` (`nom`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1024 AUTO_INCREMENT=37 ;

--
-- Contenu de la table `articles`
--

INSERT INTO `articles` (`id`, `id_famille`, `id_sous_famille`, `nom`, `code_article`, `designation`, `prix_unitaire`) VALUES
(1, 1, 2, 'Jeu de 7 déclipseurs', '1001', ' Jeu de 7 outils permettant de démonter ou dé-clipser les pièces plastiques les garnitures tout en les préservant.', '11.00'),
(2, 1, 2, 'Set extracteur manuel de pare brise', '1002', 'Outil panneau d''enlèvement avec poignée 275 mm, poinçon de perforation 350 mm, 2 poignées pour couper les fils, 1,80m de fil de coupe, poignée double crochet 240 mm, couteau extracteur manuel de pare brise.', '34.00'),
(3, 1, 2, 'Extracteur de bras d''essuie glace', '1003', ' Pour retirer les bras d''essuie-glace facilement et sans danger d''endommagement des éléments du système d''essuie-glace. Chromé anti-corrosion. Conçu pour axes droits et axes cannelés allant jusqu''à 15 mm de diamètre. ', '6.00'),
(4, 1, 2, 'Ventouse quadruple capacité 120kg', '1004', 'Ventouse quadruple en plastique. Idéal pour le maniement d''articles difficiles et lourds. Taille d''une ventouse : 115 mm. \n ', '14.00'),
(5, 1, 2, 'Ventouse triple capacité 100kg', '1005', 'Ventouse triple en plastique. Idéale pour le maniement d''articles difficiles et lourds.\nTaille d''une ventouse: 115 mm. ', '12.00'),
(6, 1, 2, 'Marteau à inertie pour carrosserie auto cabossée 330mm', '1006', 'Jeu de 5 pièces marteau pour carosserie cabossée. Marteau de 1,3 kg monté sur un manche robuste en acier galvanisé de 330mm.', '21.00'),
(7, 1, 2, 'Pince pour l''extraction des garnitures', '1007', 'En acier au carbone.\nRessort pour une plus grande influence.\nIdéal pour acceder au zones confinées.', '9.00'),
(8, 1, 2, 'Jeu de 4 extracteurs de garnitures pour auto', '1008', 'Jeu de 4 extracteur permettant de démonter ou dé-clipser les pièces plastiques les garnitures tout en les préservant.Ne marque pas les pièces plastiques ni la peinture.\n ', '15.00'),
(9, 1, 2, '5 Déclipseurs pour demonter les garnitures auto', '1009', 'Jeu de 5 outils permettant de démonter ou dé-clipser les pièces plastiques les garnitures tout en les préservant.\nNe marque pas les pièces plastiques ni la peinture.\n ', '10.00'),
(10, 1, 2, 'Couteau extracteur manuel de pare brise', '1010', ' Idéal Pour le retrait rapide et efficace du pare-brise. Ce couteau simple et confortable, permettant d’éviter les détériorations de peintures, est indispensable dans l’outillage des poseurs de pare brise', '13.00'),
(11, 1, 2, 'Coffret de réparation carrosserie marteaux tas 7 pcs', '1011', 'Idéal pour la réparation de petites bosses et le lissage de la carrosserie\nManches en fibre de verre\nCe kit comprend : 1 marteau tête ronde bombée et panne pointue, 1 marteau postillon, 1 marteau à restreindre, 4 tas', '32.00'),
(12, 1, 2, 'Outil pour le demontage des panneaux de portes', '1012', 'Permet de retirer facilement les panneaux de portes de voiture.  Permet d''enlever les clips sans dommages\n', '3.00'),
(13, 1, 1, 'Jeu de 3 pinces pour tuyaux de carburant', '1013', 'Pour demonter les raccords sur les durites de carburant essence ou diesel.', '15.00'),
(14, 1, 1, 'Depressiometre carbalancer pour synchroniser plusieurs carburateurs', '1014', 'Le Carbalancer est un dépressiométre pour la synchronisation un par un des carburateurs auto et moto.', '26.00'),
(15, 1, 1, 'Bougie colortune 14mm', '1015', 'COLORTUNE est une bougie spéciale avec lunette en verre que l’on visse à la place de la bougie normale pour regler facilement votre carburation.', '42.00'),
(16, 1, 1, 'Embout adaptateur 10mm colortune', '1016', 'Embout d’adaptation 10 mm pour bougie COLORTUNE\n', '8.00'),
(17, 1, 1, 'Embout adaptateur 18mm colortune', '1017', 'Embout d’adaptation 18 mm pour bougie COLORTUNE\n', '8.00'),
(18, 1, 3, 'Centreur d''embrayage universel avec 7 adaptateurs', '1018', 'Simple et pratique ce centreur pour embrayage universel est\nlivré avec 7 adaptateurs\nTaille des adaptateurs: 15/16/17/19/20/21/25mm.', '24.00'),
(19, 1, 3, 'Centreur d''embrayage', '1019', 'Centreur d''embrayage\n', '16.00'),
(20, 1, 3, 'Centreur d''embrayage universel avec 16 adaptateurs', '1020', 'Simple et pratique ce centreur pour embrayage universel est livré avec 16 adaptateurs\nTailles:\nAdaptateurs embouts: Ø10.6-20mm et\nGuide Manches: Ø13.7-26mm', '21.00'),
(21, 1, 3, 'Kit compresseur d''embrayage', '1021', 'Ce kit permet de démonter et remonter rapidement les embrayages de type SAC à rattrapage automatique', '211.00'),
(22, 2, 7, 'Compresseur d''air sans huile 1,5 CV 24 litres', '1022', 'Compresseur d''air puissant sans huile, 1 cylindre.\nPour utilisation avec la majorité des outils à air.\n jauges de pression de sortie, soupape de limitation de la pression et régulateur de pression.\nFournit avec PCL et connexions d''air européennes', '204.00'),
(23, 2, 8, 'Coffret outils pneumatique 33pcs Cle a choc Meuleuse Marteau', '1023', ' Le kit comprend: \nClé à chocs 1/2 "\nClé à cliquet 3/8"\nMarteau pneumatisue 150mm\nRessort pour le marteau\nMini meuleuse 1/4 "\n10 Douilles (9,10,11,13,14,17,19,22,24 et 27mm)\nAssortiment de 5 meules 1/4 "\n2 clés 4 connecteurs mâles 1/4 "\n3 Burins Pour le m', '129.00'),
(24, 2, 8, 'Soufflette pneumatique', '1024', 'Pistolet souffleur avec une grande poignée et gâchette ergonomiques pour un meilleur contrôle du nettoyage des liquides, des copeaux ou de la poussière. \n ', '4.00'),
(25, 2, 8, 'Kit accessoires pneumatiques 5 pièces', '1025', 'Kit offrant aux amateurs ou aux professionnels différentes options: pulvérisation, degonflage et nettoyage.\nComprend pistolet de pulvérisation et d''aspiration 1L, 5m tuyau enroulé, gonflage des pneus, pistolet de dégraissage et pistolet à air\n 2 connecteu', '40.00'),
(26, 2, 8, 'Soufflette pneumatique 230mm', '1026', 'Soufflette à air comprimé, pour le nettoyage des résidus.\nComprend 1 raccord rapide à baïonnette 1/4".\nLongueur totale de 23 cm', '6.00'),
(27, 2, 8, 'Cle a cliquet pneumatique 1/4"', '1027', 'Idéal pour utilisation en atelier et garage.\nMécanisme réversible vissage devissage \nCouple 13-20 Nm \nConsommation d''air 4.0 CFM\nconnecteur rapide 1/4"', '29.00'),
(28, 3, 4, 'Elingue 2 tonnes 4m', '1028', 'Charge maximum 2 tonnes.100% polyester. Anses de levage renforcées. Conforme à la norme EN1492-1:2000+AC\n', '24.00'),
(29, 3, 4, 'Elingue 2 tonnes 1m', '1029', ' Charge maximum 2 tonnes.100% polyester. Anses de levage renforcées. Conforme à la norme EN1492-1:2000+AC\n', '8.00'),
(30, 3, 4, 'Elingue 1 tonne 1m', '1030', ' Charge maximum 1 tonne. Sangle en nylon. Conforme à la norme EN1492-1:2000+AC\n', '3.00'),
(31, 3, 4, 'Elingue 1 tonne 2m', '1031', ' Charge maximum 1 tonne. Sangle en nylon. Conforme à la norme EN1492-1:2000+AC\n', '6.00'),
(32, 3, 6, 'Palan électrique 250 kg 500W', '1032', ' Soulève 125 kg de charge à 11 m ou 250 kg à 5,5m (en utilisant la poulie de renvoi fournie).\nEléments de sécurité : disjoncteur thermostatique anti-surchage, levier d''arrêt automatique et bouton d''arrêt d''urgence. ', '99.00'),
(33, 3, 6, 'Treuil à manivelle 10m', '1033', ' Câble de 10m en acier.\nDiametre du câble 4,8mm\nCharge de traction nominale : 550 Kg', '25.00'),
(34, 3, 6, 'Palan manuel à levier 6 tonnes', '1034', ' Palan manuel à levier idéal pour soulever, tirer, étirer, glisser, positionner et sécuriser. Qu''on en fasse un usage inversé ou en angle, cet équipement est particulièrement utile lorsque l''espace est restreint. De haute qualité, chaîne en acier. Testé e', '271.00'),
(35, 3, 6, 'Palan manuel à levier 750kg', '1035', ' Palan manuel à levier pour endroits étroits Idéal pour soulever, tirer, étirer, glisser, positionner et sécuriser. Qu''on en fasse un usage inversé ou en angle, cet équipement est particulièrement utile lorsque l''espace est restreint. De haute qualité, ch', '92.00'),
(36, 3, 6, 'Treuil à poulie 180kg', '1036', ' Treuil à poulie 180 kg de capacité de levage maximale. 19,8m de cordon de levage en polypropylène avec des glissières en acier chromé.\n', '8.00');

-- --------------------------------------------------------

--
-- Structure de la table `familles`
--

CREATE TABLE IF NOT EXISTS `familles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` char(50) NOT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_familles_nom` (`nom`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=4096 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `familles`
--

INSERT INTO `familles` (`id`, `nom`, `commentaire`) VALUES
(1, 'Outillage mécanique pour automobile', ' '),
(2, 'Pneumatique', ' '),
(3, 'Manutention et levage', ' ');

-- --------------------------------------------------------

--
-- Structure de la table `paniers`
--

CREATE TABLE IF NOT EXISTS `paniers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_panier` int(11) DEFAULT '0',
  `id_user` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  `qte` int(11) DEFAULT NULL,
  `prix_article` decimal(10,2) DEFAULT '0.00',
  `ok` tinyint(1) DEFAULT '0',
  `prix_total_article` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1638 AUTO_INCREMENT=76 ;

--
-- Contenu de la table `paniers`
--

INSERT INTO `paniers` (`id`, `id_panier`, `id_user`, `id_article`, `qte`, `prix_article`, `ok`, `prix_total_article`) VALUES
(74, 0, 3, 28, 1, '24.00', 0, '24.00'),
(75, 0, 1, 33, 1, '25.00', 0, '25.00');

--
-- Déclencheurs `paniers`
--
DROP TRIGGER IF EXISTS `calcul_panier_total`;
DELIMITER //
CREATE TRIGGER `calcul_panier_total` BEFORE INSERT ON `paniers`
 FOR EACH ROW BEGIN
  set new.prix_total_article = new.qte*new.prix_article;
  
  update users set panier_prix_total = (select sum(prix_total_article) FROM paniers WHERE id_user = new.id_user) WHERE users.id=new.id_user;
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `paniers_ai`;
DELIMITER //
CREATE TRIGGER `paniers_ai` AFTER INSERT ON `paniers`
 FOR EACH ROW BEGIN
  update users set panier_prix_total = (select sum(prix_total_article) FROM paniers WHERE id_user = new.id_user) WHERE users.id=new.id_user;
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `paniers_au`;
DELIMITER //
CREATE TRIGGER `paniers_au` AFTER UPDATE ON `paniers`
 FOR EACH ROW BEGIN
  
  update users set panier_prix_total = (select sum(prix_total_article) FROM paniers WHERE id_user = new.id_user) WHERE users.id=new.id_user;
  
  if  new.ok = 1 then
  update users set nb_commande = nb_commande + 1 where id = new.id_user;
  end if; 
END
//
DELIMITER ;
DROP TRIGGER IF EXISTS `update_panier_total`;
DELIMITER //
CREATE TRIGGER `update_panier_total` BEFORE UPDATE ON `paniers`
 FOR EACH ROW BEGIN
    set new.prix_total_article = new.qte*new.prix_article;
    update users set panier_prix_total = (select sum(prix_total_article) FROM paniers WHERE id_user = new.id_user) WHERE users.id=new.id_user;
    
END
//
DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `sous_familles`
--

CREATE TABLE IF NOT EXISTS `sous_familles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_famille` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `commentaire` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IX_sous_familles_id_sous_famille` (`id_famille`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1489 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `sous_familles`
--

INSERT INTO `sous_familles` (`id`, `id_famille`, `nom`, `commentaire`) VALUES
(1, 1, 'Carburation', ' '),
(2, 1, 'Carrosserie', ' '),
(3, 1, 'Embrayage', ' '),
(4, 3, 'Elingue', ' '),
(6, 3, 'Palans', ' '),
(7, 2, 'Compresseurs', ' '),
(8, 2, 'Outils pneumatiques', ' ');

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `stats_site`
--
CREATE TABLE IF NOT EXISTS `stats_site` (
`id` int(11)
,`nom` char(50)
,`prenom` char(50)
,`nb_commande` int(11)
,`nb_articles` decimal(32,0)
);
-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `raison_sociale` char(50) DEFAULT NULL,
  `nom` char(50) NOT NULL,
  `prenom` char(50) DEFAULT NULL,
  `mail` char(50) NOT NULL,
  `mot_de_passe` varchar(50) NOT NULL,
  `fadresse1` varchar(255) DEFAULT NULL,
  `fadresse2` varchar(255) DEFAULT NULL,
  `fcp` varchar(20) DEFAULT NULL,
  `fville` varchar(255) DEFAULT NULL,
  `ladresse1` varchar(255) DEFAULT NULL,
  `ladresse2` varchar(255) DEFAULT NULL,
  `lcp` varchar(20) DEFAULT NULL,
  `lville` varchar(255) DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT '0',
  `gestionnaire` tinyint(4) NOT NULL DEFAULT '0',
  `panier_prix_total` decimal(10,2) NOT NULL DEFAULT '0.00',
  `nb_commande` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_users_mail` (`mail`),
  KEY `IX_users_mot_de_passe` (`mot_de_passe`),
  KEY `IX_users_nom` (`nom`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `raison_sociale`, `nom`, `prenom`, `mail`, `mot_de_passe`, `fadresse1`, `fadresse2`, `fcp`, `fville`, `ladresse1`, `ladresse2`, `lcp`, `lville`, `admin`, `gestionnaire`, `panier_prix_total`, `nb_commande`) VALUES
(1, '123', 'HA', 'AA', 'zeee@lol.fr', '123', '', '', '', '', '', '', '', '', 1, 1, '25.00', 2),
(3, '432', 'HAUTIER', 'JULIEN', 'vijuh@hotmail.fr', '123', '3 rue Pierre Haret', '', '75009', 'PARIS', '', '', '', '', 0, 0, '24.00', 0);

-- --------------------------------------------------------

--
-- Doublure de structure pour la vue `view1`
--
CREATE TABLE IF NOT EXISTS `view1` (
`id` bigint(11)
,`nom` varchar(50)
,`prenom` char(50)
,`nb_commande` bigint(11)
,`SUM(qte)` decimal(32,0)
);
-- --------------------------------------------------------

--
-- Structure de la vue `stats_site`
--
DROP TABLE IF EXISTS `stats_site`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `stats_site` AS select `users`.`id` AS `id`,`users`.`nom` AS `nom`,`users`.`prenom` AS `prenom`,`users`.`nb_commande` AS `nb_commande`,sum(`paniers`.`qte`) AS `nb_articles` from (`users` left join `paniers` on((`users`.`id` = `paniers`.`id_user`))) group by `users`.`id`;

-- --------------------------------------------------------

--
-- Structure de la vue `view1`
--
DROP TABLE IF EXISTS `view1`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view1` AS select `users`.`id` AS `id`,`users`.`nom` AS `nom`,`users`.`prenom` AS `prenom`,`users`.`nb_commande` AS `nb_commande`,sum(`paniers`.`qte`) AS `SUM(qte)` from (`users` left join `paniers` on((`users`.`id` = `paniers`.`id_user`))) where (`paniers`.`ok` = 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
