<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Avis
 *
 * @ORM\Table(name="avis", indexes={@ORM\Index(name="idUser", columns={"idUser"}), @ORM\Index(name="idEvenement", columns={"idEvenement"})})
 * @ORM\Entity
 */
class Avis
{
    /**
     * @var int
     *
     * @ORM\Column(name="idAvis", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idavis;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionAvis", type="text", length=0, nullable=false)
     */
    private $descriptionavis;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heureAvis", type="time", nullable=false)
     */
    private $heureavis;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="Avi_date", type="date", nullable=false)
     */
    private $aviDate;

    /**
     * @var bool
     *
     * @ORM\Column(name="likeAvis", type="boolean", nullable=false)
     */
    private $likeavis;

    /**
     * @var float
     *
     * @ORM\Column(name="rate", type="float", precision=10, scale=0, nullable=false)
     */
    private $rate;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;

    /**
     * @var int
     *
     * @ORM\Column(name="idEvenement", type="integer", nullable=false)
     */
    private $idevenement;


}
