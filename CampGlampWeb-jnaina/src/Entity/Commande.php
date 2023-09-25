<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Commande
 *
 * @ORM\Table(name="commande", indexes={@ORM\Index(name="idUser", columns={"idUser"}), @ORM\Index(name="idProduit", columns={"idProduit"})})
 * @ORM\Entity
 */
class Commande
{
    /**
     * @var int
     *
     * @ORM\Column(name="idCommande", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idcommande;

    /**
     * @var string
     *
     * @ORM\Column(name="numeroDeCommande", type="string", length=20, nullable=false)
     */
    private $numerodecommande;

    /**
     * @var int
     *
     * @ORM\Column(name="PrixCommande", type="integer", nullable=false)
     */
    private $prixcommande;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="dateCommande", type="date", nullable=false)
     */
    private $datecommande;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var int
     *
     * @ORM\Column(name="idProduit", type="integer", nullable=false)
     */
    private $idproduit;


}
