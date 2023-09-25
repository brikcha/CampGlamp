<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * CentreDeCamping
 *
 * @ORM\Table(name="centre de camping")
 * @ORM\Entity
 */
class CentreDeCamping
{
    /**
     * @var int
     *
     * @ORM\Column(name="idCentre", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idcentre;

    /**
     * @var string
     *
     * @ORM\Column(name="nomCentre", type="string", length=50, nullable=false)
     */
    private $nomcentre;

    /**
     * @var string
     *
     * @ORM\Column(name="adresseCentre", type="string", length=50, nullable=false)
     */
    private $adressecentre;

    /**
     * @var float
     *
     * @ORM\Column(name="prixCentre", type="float", precision=10, scale=0, nullable=false)
     */
    private $prixcentre;

    /**
     * @var string
     *
     * @ORM\Column(name="typeCentre", type="string", length=50, nullable=false)
     */
    private $typecentre;

    /**
     * @var string
     *
     * @ORM\Column(name="VilleCentre", type="string", length=50, nullable=false)
     */
    private $villecentre;

    /**
     * @var string
     *
     * @ORM\Column(name="gouvernorat", type="string", length=50, nullable=false)
     */
    private $gouvernorat;


}
