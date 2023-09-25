<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CampService
 *
 * @ORM\Table(name="camp_service", indexes={@ORM\Index(name="IDX_910ED9BCA5B142EF", columns={"idCentre"})})
 * @ORM\Entity
 */
class CampService
{
    /**
     * @var int
     *
     * @ORM\Column(name="idService", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     */
    private $idservice;

    /**
     * @var \CentreDeCamping
     *
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="NONE")
     * @ORM\OneToOne(targetEntity="CentreDeCamping")
     * @ORM\JoinColumns({
     *   @ORM\JoinColumn(name="idCentre", referencedColumnName="idCentre")
     * })
     */
    private $idcentre;


}
