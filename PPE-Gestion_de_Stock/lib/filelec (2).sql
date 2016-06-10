-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Ven 10 Juin 2016 à 22:16
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

DELIMITER $$
--
-- Procédures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_D1`(idA int)
begin
SELECT COUNT(*) 
FROM articles 
WHERE id=idA;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_D2`(idA int)
begin
DELETE FROM articles 
WHERE id=idA;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_I`(IN idF int, IN idSF int, IN nomA varchar(255), IN codeA varchar(255), IN designationA varchar(255), IN prixU decimal, IN quantiteA int, IN idA int)
begin
INSERT INTO articles(id, id_famille, id_sous_famille, nom, code_article, designation, prix_unitaire, quantite) 
VALUES ("", idF, idSF, nomA, codeA, designationA, prixU, quantiteA);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_SA`()
BEGIN
SELECT * 
FROM articles;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_SW`(IN cle VARCHAR(255))
BEGIN
SELECT * 
FROM articles
WHERE nom LIKE concat("%",cle,"%")
OR designation LIKE concat("%",cle,"%");
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_U1`(idA int)
begin
SELECT COUNT(*) 
FROM articles 
WHERE id=idA; 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleA_U2`(idF int, idSF int, nomA varchar(255), codeA varchar(255), designationA varchar(255), prixU decimal(10,2), quantiteA int, idA int)
begin
UPDATE articles 
SET id_famille = idF, 
id_sous_famille = idSF,
nom = nomA, 
code_article = codeA,
designation = designationA,
prix_unitaire = prixU,
quantite = quantiteA
WHERE id=idA;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleF_D1`(IN idF INT(3))
BEGIN
SELECT COUNT(*)
FROM familles
WHERE id=idF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleF_D2`(IN idF INT(3))
BEGIN
DELETE FROM familles 
WHERE id=idF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleF_I`(IN idF VARCHAR(255), IN nomF VARCHAR(255), IN commF VARCHAR(255))
BEGIN
INSERT INTO Familles(id, nom, commentaire) 
VALUES ("", nomF, commF);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleF_SA`()
BEGIN
SELECT *
FROM Familles;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleF_U1`(IN idF INT(3))
BEGIN
SELECT COUNT(*)
FROM Familles
WHERE id=idF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleF_U2`(IN nomF VARCHAR(255), IN commF VARCHAR(255), IN idF INT(3))
BEGIN
UPDATE familles 
SET nom=nomF, commentaire=commF 
WHERE id=idF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleSF_D1`(IN idSF INT(3))
BEGIN
SELECT COUNT(*) 
FROM sous_familles 
WHERE id=idSF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleSF_D2`(IN idSF INT(3))
BEGIN
DELETE FROM sous_familles 
WHERE id=idSF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleSF_I`(IN idSF INT(3), IN idF INT(3), IN nomSF VARCHAR(255), IN commSF VARCHAR(255))
BEGIN
INSERT INTO sous_familles(id, id_famille, nom, commentaire) 
VALUES ("",idF,nomSF,commSF);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleSF_SA`()
BEGIN
SELECT * 
FROM sous_familles;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleSF_U1`(IN idSF INT(3))
BEGIN
SELECT COUNT(*) 
FROM sous_familles 
WHERE id=idSF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleSF_U2`(IN idSF INT(3), IN idF INT(3), IN nomSF VARCHAR(255), IN commSF VARCHAR(255))
BEGIN
UPDATE sous_familles 
SET id_famille=idF, nom=nomSF, commentaire=commSF 
WHERE id=idSF;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_D1`(idU int)
begin
SELECT COUNT(*) 
FROM users 
WHERE id=idU;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_D2`(idU int)
begin
DELETE FROM users 
WHERE id=idU;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_I`(idU int, RS varchar(255), nomU varchar(255), 
	prenomU varchar(255), email varchar(255), mdpd varchar(255), 
	factad1 varchar(255), factad2 varchar(255), factcp varchar(255), factville varchar(255), 
	livadresse1 varchar(255), livadresse2 varchar(255), livcp varchar(255), livville varchar(255), 
	adminn varchar(255), gestionnairre varchar(255), nbcommande int)
begin
INSERT INTO users(id, raison_sociale, nom, prenom, mail, mot_de_passe, fadresse1, fadresse2, fcp, fville, ladresse1, ladresse2, lcp, lville, admin, gestionnaire, nb_commande) 
VALUES ("", RS, nomU, 
	prenomU, email, mdpd, 
	factad1, factad2, factcp, factville, 
	livadresse1, livadresse2, livcp, livville, 
	adminn, gestionnairre, nbcommande);
	end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_SA`()
begin
SELECT * 
FROM users;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_SC`(email varchar(255), mdp varchar(255))
begin
SELECT COUNT(mail) AS nb, nom, prenom 
FROM users 
WHERE mail =email 
AND mot_de_passe =mdp 
AND (admin = 1 OR gestionnaire = 1);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_SW`(IN cle char(50))
BEGIN
SELECT * FROM users 
WHERE nom LIKE CONCAT("%",cle,"%") 
OR prenom LIKE CONCAT("%",cle,"%") 
OR mail LIKE CONCAT("%",cle,"%");
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_U1`(idU int)
begin
SELECT COUNT(*) 
FROM users 
WHERE id=idU;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `modeleU_U2`(IN idU INT, IN RS VARCHAR(255), IN nomU VARCHAR(255), IN prenomU VARCHAR(255), IN email VARCHAR(255), IN mdp VARCHAR(255), IN factad1 VARCHAR(255), IN factad2 VARCHAR(255), IN factcp VARCHAR(255), IN factville VARCHAR(255), IN livadresse1 VARCHAR(255), IN livadresse2 VARCHAR(255), IN livcp VARCHAR(255), IN livville VARCHAR(255), IN adminn VARCHAR(255), IN gestionnairre VARCHAR(255))
begin
UPDATE users SET raison_sociale=RS, 
nom=nomU, 
prenom=prenomU, 
mail=email, 
mot_de_passe=mdp, 
fadresse1=factad1, 
fadresse2=factad2, 
fcp=factcp, 
fville=factville, 
ladresse1=livadresse1, 
ladresse2=livadresse2, 
lcp=livcp, 
lville=livville, 
admin=adminn, 
gestionnaire=gestionnairre
WHERE id=idU;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procArtPlusComm`()
BEGIN
SELECT articles.id, articles.nom, sum(paniers.qte) as totalArticles
FROM articles INNER JOIN paniers ON articles.id = paniers.id_article
GROUP BY articles.id
ORDER BY totalArticles DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procArtPrixASC`()
BEGIN
SELECT id, nom, code_article, prix_unitaire
FROM articles
ORDER BY prix_unitaire ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procArtPrixDESC`()
BEGIN
SELECT id, nom, code_article, prix_unitaire
FROM articles
ORDER BY prix_unitaire DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procClientsOk`()
BEGIN
 SELECT u.id, u.nom, u.prenom from paniers p, users u
 WHERE ok=1
 AND p.id_user=u.id
 GROUP BY u.id;
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procClientsPasOk`()
BEGIN
 SELECT u.id, u.nom, u.prenom from paniers p, users u
 WHERE ok=0
 AND p.id_user=u.id
 GROUP BY u.id;
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procedure1`()
BEGIN
SELECT id, nom, prenom, mail 
FROM users 
order by nom DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procedureTest1`()
BEGIN
SELECT * FROM stats_site;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procNbCommJour`()
BEGIN
 SELECT count(*) as nbComm, CURDATE() as dateJour from paniers
 WHERE ok=1
 AND DAY(date_panier)=DAY(curdate());
 END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procNbCommMois`()
BEGIN
 SELECT count(*) as nbComm, concat(Month(curdate()),"/",year(CURDATE())) as dateMois from paniers
 WHERE ok=1
 AND MONTH(date_panier)=MONTH(curdate());
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procStatsVenteNoel`()
BEGIN
SELECT articles.id, articles.nom, sum(paniers.qte) as totalArticles
FROM articles INNER JOIN paniers ON articles.id = paniers.id_article
where month(paniers.date_panier) = 12 
GROUP BY articles.id
ORDER BY totalArticles DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procUsrNbArtASC`()
BEGIN
SELECT id, nom, prenom, nb_articles 
FROM stats_site
ORDER BY nb_articles ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procUsrNbArtDESC`()
BEGIN
SELECT id, nom, prenom, nb_articles 
FROM stats_site
ORDER BY nb_articles DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procUsrNbCommASC`()
BEGIN
SELECT id, nom, prenom, nb_commande
FROM stats_site
ORDER BY nb_commande ASC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procUsrNbCommDESC`()
BEGIN
SELECT id, nom, prenom, nb_commande
FROM stats_site
ORDER BY nb_commande DESC;
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `procUsrPlusDepense`()
BEGIN
SELECT users.id, users.nom, users.prenom, users.panier_prix_total
FROM users
ORDER BY users.panier_prix_total DESC;
END$$

DELIMITER ;

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
  `quantite` int(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_articles_code_article` (`code_article`),
  KEY `IX_articles_id_famille` (`id_famille`),
  KEY `IX_articles_id_sous_famille` (`id_sous_famille`),
  KEY `IX_articles_nom` (`nom`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1024 AUTO_INCREMENT=129 ;

--
-- Contenu de la table `articles`
--

INSERT INTO `articles` (`id`, `id_famille`, `id_sous_famille`, `nom`, `code_article`, `designation`, `prix_unitaire`, `quantite`) VALUES
(1, 1, 2, 'Jeu de 7 déclipseurs', '1001', ' Jeu de 7 outils permettant de démonter ou dé-clipser les pièces plastiques les garnitures tout en les préservant.', '11.00', 0),
(2, 1, 2, 'Set extracteur manuel de pare brise', '1002', 'Outil panneau d''enlèvement avec poignée 275 mm, poinçon de perforation 350 mm, 2 poignées pour couper les fils, 1,80m de fil de coupe, poignée double crochet 240 mm, couteau extracteur manuel de pare brise.', '34.00', 0),
(3, 1, 2, 'Extracteur de bras d''essuie glace', '1003', ' Pour retirer les bras d''essuie-glace facilement et sans danger d''endommagement des éléments du système d''essuie-glace. Chromé anti-corrosion. Conçu pour axes droits et axes cannelés allant jusqu''à 15 mm de diamètre. ', '6.00', 0),
(4, 1, 2, 'Ventouse quadruple capacité 120kg', '1004', 'Ventouse quadruple en plastique. Idéal pour le maniement d''articles difficiles et lourds. Taille d''une ventouse : 115 mm. \n ', '14.00', 0),
(5, 1, 2, 'Ventouse triple capacité 100kg', '1005', 'Ventouse triple en plastique. Idéale pour le maniement d''articles difficiles et lourds.\nTaille d''une ventouse: 115 mm. ', '12.00', 0),
(6, 1, 2, 'Marteau à inertie pour carrosserie auto cabossée 330mm', '1006', 'Jeu de 5 pièces marteau pour carosserie cabossée. Marteau de 1,3 kg monté sur un manche robuste en acier galvanisé de 330mm.', '21.00', 0),
(7, 1, 2, 'Pince pour l''extraction des garnitures', '1007', 'En acier au carbone.\nRessort pour une plus grande influence.\nIdéal pour acceder au zones confinées.', '9.00', 0),
(8, 1, 2, 'Jeu de 4 extracteurs de garnitures pour auto', '1008', 'Jeu de 4 extracteur permettant de démonter ou dé-clipser les pièces plastiques les garnitures tout en les préservant.Ne marque pas les pièces plastiques ni la peinture.\n ', '15.00', 0),
(9, 1, 2, '5 Déclipseurs pour demonter les garnitures auto', '1009', 'Jeu de 5 outils permettant de démonter ou dé-clipser les pièces plastiques les garnitures tout en les préservant.\nNe marque pas les pièces plastiques ni la peinture.\n ', '10.00', 0),
(10, 1, 2, 'Couteau extracteur manuel de pare brise', '1010', ' Idéal Pour le retrait rapide et efficace du pare-brise. Ce couteau simple et confortable, permettant d’éviter les détériorations de peintures, est indispensable dans l’outillage des poseurs de pare brise', '13.00', 0),
(11, 1, 2, 'Coffret de réparation carrosserie marteaux tas 7 pcs', '1011', 'Idéal pour la réparation de petites bosses et le lissage de la carrosserie\nManches en fibre de verre\nCe kit comprend : 1 marteau tête ronde bombée et panne pointue, 1 marteau postillon, 1 marteau à restreindre, 4 tas', '32.00', 0),
(12, 1, 2, 'Outil pour le demontage des panneaux de portes', '1012', 'Permet de retirer facilement les panneaux de portes de voiture.  Permet d''enlever les clips sans dommages\n', '3.00', 0),
(13, 1, 1, 'Jeu de 3 pinces pour tuyaux de carburant', '1013', 'Pour demonter les raccords sur les durites de carburant essence ou diesel.', '15.00', 0),
(14, 1, 1, 'Depressiometre carbalancer pour synchroniser plusieurs carburateurs', '1014', 'Le Carbalancer est un dépressiométre pour la synchronisation un par un des carburateurs auto et moto.', '26.00', 0),
(15, 1, 1, 'Bougie colortune 14mm', '1015', 'COLORTUNE est une bougie spéciale avec lunette en verre que l’on visse à la place de la bougie normale pour regler facilement votre carburation.', '42.00', 0),
(16, 1, 1, 'Embout adaptateur 10mm colortune', '1016', 'Embout d’adaptation 10 mm pour bougie COLORTUNE\n', '8.00', 0),
(17, 1, 1, 'Embout adaptateur 18mm colortune', '1017', 'Embout d’adaptation 18 mm pour bougie COLORTUNE\n', '8.00', 0),
(18, 1, 3, 'Centreur d''embrayage universel avec 7 adaptateurs', '1018', 'Simple et pratique ce centreur pour embrayage universel est\nlivré avec 7 adaptateurs\nTaille des adaptateurs: 15/16/17/19/20/21/25mm.', '24.00', 0),
(19, 1, 3, 'Centreur d''embrayage', '1019', 'Centreur d''embrayage\n', '16.00', 0),
(20, 1, 3, 'Centreur d''embrayage universel avec 16 adaptateurs', '1020', 'Simple et pratique ce centreur pour embrayage universel est livré avec 16 adaptateurs\nTailles:\nAdaptateurs embouts: Ø10.6-20mm et\nGuide Manches: Ø13.7-26mm', '21.00', 0),
(21, 1, 3, 'Kit compresseur d''embrayage', '1021', 'Ce kit permet de démonter et remonter rapidement les embrayages de type SAC à rattrapage automatique', '211.00', 0),
(22, 2, 7, 'Compresseur d''air sans huile 1,5 CV 24 litres', '1022', 'Compresseur d''air puissant sans huile, 1 cylindre.\nPour utilisation avec la majorité des outils à air.\n jauges de pression de sortie, soupape de limitation de la pression et régulateur de pression.\nFournit avec PCL et connexions d''air européennes', '204.00', 0),
(23, 2, 8, 'Coffret outils pneumatique 33pcs Cle a choc Meuleuse Marteau', '1023', ' Le kit comprend: \nClé à chocs 1/2 "\nClé à cliquet 3/8"\nMarteau pneumatisue 150mm\nRessort pour le marteau\nMini meuleuse 1/4 "\n10 Douilles (9,10,11,13,14,17,19,22,24 et 27mm)\nAssortiment de 5 meules 1/4 "\n2 clés 4 connecteurs mâles 1/4 "\n3 Burins Pour le m', '129.00', 0),
(24, 2, 8, 'Soufflette pneumatique', '1024', 'Pistolet souffleur avec une grande poignée et gâchette ergonomiques pour un meilleur contrôle du nettoyage des liquides, des copeaux ou de la poussière. \n ', '4.00', 0),
(25, 2, 8, 'Kit accessoires pneumatiques 5 pièces', '1025', 'Kit offrant aux amateurs ou aux professionnels différentes options: pulvérisation, degonflage et nettoyage.\nComprend pistolet de pulvérisation et d''aspiration 1L, 5m tuyau enroulé, gonflage des pneus, pistolet de dégraissage et pistolet à air\n 2 connecteu', '40.00', 0),
(26, 2, 8, 'Soufflette pneumatique 230mm', '1026', 'Soufflette à air comprimé, pour le nettoyage des résidus.\nComprend 1 raccord rapide à baïonnette 1/4".\nLongueur totale de 23 cm', '6.00', 0),
(27, 2, 8, 'Cle a cliquet pneumatique 1/4"', '1027', 'Idéal pour utilisation en atelier et garage.\nMécanisme réversible vissage devissage \nCouple 13-20 Nm \nConsommation d''air 4.0 CFM\nconnecteur rapide 1/4"', '29.00', 0),
(28, 3, 4, 'Elingue 2 tonnes 4m', '1028', 'Charge maximum 2 tonnes.100% polyester. Anses de levage renforcées. Conforme à la norme EN1492-1:2000+AC\n', '24.00', 0),
(29, 3, 4, 'Elingue 2 tonnes 1m', '1029', ' Charge maximum 2 tonnes.100% polyester. Anses de levage renforcées. Conforme à la norme EN1492-1:2000+AC\n', '8.00', 0),
(30, 3, 4, 'Elingue 1 tonne 1m', '1030', ' Charge maximum 1 tonne. Sangle en nylon. Conforme à la norme EN1492-1:2000+AC\n', '3.00', 0),
(31, 3, 4, 'Elingue 1 tonne 2m', '1031', ' Charge maximum 1 tonne. Sangle en nylon. Conforme à la norme EN1492-1:2000+AC\n', '6.00', 0),
(32, 3, 6, 'Palan électrique 250 kg 500W', '1032', ' Soulève 125 kg de charge à 11 m ou 250 kg à 5,5m (en utilisant la poulie de renvoi fournie).\nEléments de sécurité : disjoncteur thermostatique anti-surchage, levier d''arrêt automatique et bouton d''arrêt d''urgence. ', '99.00', 0),
(33, 3, 6, 'Treuil à manivelle 10m', '1033', ' Câble de 10m en acier.\nDiametre du câble 4,8mm\nCharge de traction nominale : 550 Kg', '25.00', 0),
(34, 3, 6, 'Palan manuel à levier 6 tonnes', '1034', ' Palan manuel à levier idéal pour soulever, tirer, étirer, glisser, positionner et sécuriser. Qu''on en fasse un usage inversé ou en angle, cet équipement est particulièrement utile lorsque l''espace est restreint. De haute qualité, chaîne en acier. Testé e', '271.00', 0),
(35, 3, 6, 'Palan manuel à levier 750kg', '1035', ' Palan manuel à levier pour endroits étroits Idéal pour soulever, tirer, étirer, glisser, positionner et sécuriser. Qu''on en fasse un usage inversé ou en angle, cet équipement est particulièrement utile lorsque l''espace est restreint. De haute qualité, ch', '92.00', 0),
(36, 3, 6, 'Treuil à poulie 180kg', '1036', ' Treuil à poulie 180 kg de capacité de levage maximale. 19,8m de cordon de levage en polypropylène avec des glissières en acier chromé.\n', '8.00', 0),
(125, 1, 2, 'testfinal2', '121222', 'testfinal2', '10.00', 10);

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=4096 AUTO_INCREMENT=8 ;

--
-- Contenu de la table `familles`
--

INSERT INTO `familles` (`id`, `nom`, `commentaire`) VALUES
(1, 'Outillage mécanique pour automobile', ' '),
(2, 'Pneumatique', ' '),
(3, 'Manutention et levage', ' '),
(7, 'joPedro', 'vasy dit lui');

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
  `date_panier` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1638 AUTO_INCREMENT=83 ;

--
-- Contenu de la table `paniers`
--

INSERT INTO `paniers` (`id`, `id_panier`, `id_user`, `id_article`, `qte`, `prix_article`, `ok`, `prix_total_article`, `date_panier`) VALUES
(74, 0, 3, 28, 1, '24.00', 0, '24.00', NULL),
(75, 0, 1, 33, 11, '25.00', 1, '275.00', NULL),
(76, 0, 1, 30, 10, '3.00', 1, '30.00', '2016-12-30'),
(77, 0, 1, 35, 1, '92.00', 1, '92.00', '2016-06-01'),
(78, 0, 1, 34, 1, '271.00', 1, '271.00', '2016-06-01'),
(79, 0, 1, 32, 1, '99.00', 1, '99.00', '2016-06-01'),
(80, 0, 1, 36, 1, '8.00', 1, '8.00', '2016-12-01'),
(81, 0, 1, 29, 1, '8.00', 1, '8.00', '2016-06-01'),
(82, 0, 1, 28, 1, '24.00', 1, '24.00', '2016-12-01');

--
-- Déclencheurs `paniers`
--
DROP TRIGGER IF EXISTS `calcul_panier_total`;
DELIMITER //
CREATE TRIGGER `calcul_panier_total` BEFORE INSERT ON `paniers`
 FOR EACH ROW BEGIN
  set new.prix_total_article = new.qte*new.prix_article;
  set new.date_panier = curdate();
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
  
  update users 
  set panier_prix_total = (select sum(prix_total_article) 
                           FROM paniers WHERE id_user = new.id_user) 
                           WHERE users.id=new.id_user;
  
  if  new.ok = 1 then
  update users set nb_commande = nb_commande + 1 
  where id = new.id_user;
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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=1489 AUTO_INCREMENT=13 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AVG_ROW_LENGTH=2048 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `raison_sociale`, `nom`, `prenom`, `mail`, `mot_de_passe`, `fadresse1`, `fadresse2`, `fcp`, `fville`, `ladresse1`, `ladresse2`, `lcp`, `lville`, `admin`, `gestionnaire`, `panier_prix_total`, `nb_commande`) VALUES
(1, '123', 'HA', 'AA', 'zeee@lol.fr', '123', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 1, 1, '807.00', 19),
(3, '432', 'HAUTIER', 'JULIEN', 'vijuh@hotmail.fr', '123', '3 rue Pierre Haret', '', '75009', 'PARIS', '', '', '', '', 0, 0, '24.00', 0),
(8, '222', 'lele', 'letest', 'letest@lol.fr', '123', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 1, 1, '0.00', 0);

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
