<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Panier
 *
 * @ORM\Table(name="panier", indexes={@ORM\Index(name="idUser", columns={"idUser"}), @ORM\Index(name="idProduit", columns={"idProduit"})})
 * @ORM\Entity
 */
class Panier
{
    /**
     * @var int
     *
     * @ORM\Column(name="idPanier", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idpanier;

    /**
     * @var int
     *
     * @ORM\Column(name="referencePanier", type="integer", nullable=false)
     */
    private $referencepanier;

    /**
     * @var int
     *
     * @ORM\Column(name="totalPrixProduit", type="integer", nullable=false)
     */
    private $totalprixproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="nbTotalProduit", type="integer", nullable=false)
     */
    private $nbtotalproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="idProduit", type="integer", nullable=false)
     */
    private $idproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;


}
