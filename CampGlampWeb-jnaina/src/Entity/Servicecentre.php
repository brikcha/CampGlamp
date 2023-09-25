<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Servicecentre
 *
 * @ORM\Table(name="servicecentre", indexes={@ORM\Index(name="fkj", columns={"idCentre"})})
 * @ORM\Entity
 */
class Servicecentre
{
    /**
     * @var int
     *
     * @ORM\Column(name="idService", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idservice;

    /**
     * @var string
     *
     * @ORM\Column(name="typeService", type="string", length=255, nullable=false)
     */
    private $typeservice;

    /**
     * @var string
     *
     * @ORM\Column(name="nomRestaurant", type="string", length=255, nullable=false)
     */
    private $nomrestaurant;

    /**
     * @var string
     *
     * @ORM\Column(name="menu", type="string", length=255, nullable=false)
     */
    private $menu;

    /**
     * @var int
     *
     * @ORM\Column(name="capacite", type="integer", nullable=false)
     */
    private $capacite;

    /**
     * @var bool
     *
     * @ORM\Column(name="disponibilitÃ©", type="boolean", nullable=false)
     */
    private $disponibilitã©;

    /**
     * @var \CentreDeCamping
     *
     * @ORM\ManyToOne(targetEntity="CentreDeCamping")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idCentre", referencedColumnName="idCentre")
     * })
     */
    private $idcentre;


}
