<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Produit
 *
 * @ORM\Table(name="produit", indexes={@ORM\Index(name="idActivite", columns={"idActivite"})})
 * @ORM\Entity
 */
class Produit
{
    /**
     * @var int
     *
     * @ORM\Column(name="idProduit", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="referenceProduit", type="integer", nullable=false)
     */
    private $referenceproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="nomProduit", type="text", length=65535, nullable=false)
     */
    private $nomproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="prixProduit", type="text", length=65535, nullable=false)
     */
    private $prixproduit;

    /**
     * @var int
     *
     * @ORM\Column(name="quantiteProduit", type="integer", nullable=false)
     */
    private $quantiteproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="marqueProduit", type="text", length=65535, nullable=false)
     */
    private $marqueproduit;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionProduit", type="text", length=65535, nullable=false)
     */
    private $descriptionproduit;

    /**
     * @var string|null
     *
     * @ORM\Column(name="typeProduit", type="text", length=65535, nullable=true)
     */
    private $typeproduit;

    /**
     * @var string|null
     *
     * @ORM\Column(name="couleur", type="text", length=65535, nullable=true)
     */
    private $couleur;

    /**
     * @var string|null
     *
     * @ORM\Column(name="taille", type="text", length=65535, nullable=true)
     */
    private $taille;

    /**
     * @var string
     *
     * @ORM\Column(name="imageProduit", type="text", length=65535, nullable=false)
     */
    private $imageproduit;

    /**
     * @var int|null
     *
     * @ORM\Column(name="idActivite", type="integer", nullable=true)
     */
    private $idactivite;


}
