CREATE TABLE `pizzas` (
  `id` int(11) NOT NULL,
  `categorie` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `url_image` varchar(255) DEFAULT NULL
);


INSERT INTO `pizzas` (`id`, `categorie`, `code`, `nom`, `prix`, `url_image`) VALUES
(1, 'VIANDE', 'CAN', 'CANNIBALE', 230, NULL),
(2, 'VIANDE', 'FRO', '4 FROMAGES', 589, NULL),
(3, 'VIANDE', 'MAR', 'MARGHARITA', 458, NULL),
(4, 'VIANDE', 'PEP', 'PEPERONI', 187, NULL),
(5, 'VIANDE', 'CAN', 'CANNIBALE', 230, NULL),
(6, 'VIANDE', 'FRO', '4 FROMAGES', 589, NULL),
(7, 'VIANDE', 'MAR', 'MARGHARITA', 458, NULL),
(8, 'VIANDE', 'PEP', 'PEPERONI', 187, NULL),
(10, 'VIANDE', 'FRO', '4 FROMAGES', 589, NULL),
(11, 'VIANDE', 'MAR', 'MARGHARITA', 458, NULL),
(12, 'VIANDE', 'PEP', 'PEPERONI', 187, NULL),
(13, 'VIANDE', 'CAN', 'CANNIBALE', 230, NULL),
(14, 'VIANDE', 'FRO', '4 FROMAGES', 589, NULL),
(15, 'VIANDE', 'MAR', 'MARGHARITA', 458, NULL),
(16, 'VIANDE', 'PEP', 'PEPERONI', 187, NULL),
(17, 'VIANDE', 'HELLO', '2017', 230, NULL);
