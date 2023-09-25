<?php

namespace App\Entity;

use Doctrine\ORM\Mapping as ORM;

/**
 * Notifications
 *
 * @ORM\Table(name="notifications", indexes={@ORM\Index(name="idUser", columns={"idUser"})})
 * @ORM\Entity
 */
class Notifications
{
    /**
     * @var int
     *
     * @ORM\Column(name="idNotif", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $idnotif;

    /**
     * @var string
     *
     * @ORM\Column(name="titre", type="string", length=255, nullable=false)
     */
    private $titre;

    /**
     * @var string
     *
     * @ORM\Column(name="descriptionNotif", type="string", length=255, nullable=false)
     */
    private $descriptionnotif;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="date_notif", type="date", nullable=false)
     */
    private $dateNotif;

    /**
     * @var \DateTime
     *
     * @ORM\Column(name="heureNotif", type="time", nullable=false)
     */
    private $heurenotif;

    /**
     * @var bool
     *
     * @ORM\Column(name="vu", type="boolean", nullable=false)
     */
    private $vu;

    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     */
    private $iduser;


}
