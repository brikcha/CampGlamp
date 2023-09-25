<?php

namespace App\Entity;
use App\Repository\UtilisateursRepository;
use Doctrine\ORM\Mapping as ORM;
use Symfony\Component\Validator\Constraints as Assert;
/**
 * Utilisateurs
 *
 * @ORM\Table(name="utilisateurs", uniqueConstraints={@ORM\UniqueConstraint(name="emailunique", columns={"email"}), @ORM\UniqueConstraint(name="Uniquecin", columns={"cinUser"})})
 * @ORM\Entity
 * @ORM\Entity(repositoryClass=UtilisateursRepository::class)
 */
class Utilisateurs
{
    /**
     * @var int
     *
     * @ORM\Column(name="idUser", type="integer", nullable=false)
     * @ORM\Id
     * @ORM\GeneratedValue(strategy="IDENTITY")
     */
    private $iduser;

    /**
     * @var string
     *
     * @ORM\Column(name="cinUser", type="string", length=8, nullable=false)
     * @Assert\NotBlank(message="Numero carte d'identité est obligatoire")
     
     */
    private $cinuser;

    /**
     * @var string
     *
     * @ORM\Column(name="nomUser", type="string", length=25, nullable=false)
     *  @Assert\NotBlank(message=" Le nom est obligatoire")
     */
    private $nomuser;

    /**
     * @var string
     *
     * @ORM\Column(name="prenomUser", type="string", length=25, nullable=false)
     * @Assert\NotBlank(message=" Le prenom est obligatoire")
     */
    private $prenomuser;

    /**
     * @var string
     *
     * @ORM\Column(name="telUser", type="string", length=8, nullable=false)
     * @Assert\NotBlank(message="Numero de téléphone  est obligatoire")
     
     */
    private $teluser;

    /**
     * @var string
     *
     * @ORM\Column(name="adresseUser", type="string", length=35, nullable=false)
     * @Assert\NotBlank(message="L'adresse est obligatoire")

     */
    private $adresseuser;

    /**
     * @var string
     *
     * @ORM\Column(name="email", type="string", length=25, nullable=false)
     * @Assert\NotBlank(message="Email est obligatoire")
     * @Assert\Email(message = "L'email '{{ value }}' n'est pas valide.")
     */
    private $email;

    /**
     * @var string
     *
     * @ORM\Column(name="motdepasse", type="string", length=50, nullable=false)
     * @Assert\NotBlank(message="Mot de passe est obligatoire")
     
     */
    private $motdepasse;

    /**
     * @var string
     *
     * @ORM\Column(name="role", type="string", length=11, nullable=false)
     *  @Assert\NotBlank(message="role est obligatoire")

     */
    private $role;

    /**
     * @var string|null
     *
     * @ORM\Column(name="image", type="string", length=50, nullable=true)
     */
    private $image;

    /**
     * @var float|null
     *
     * @ORM\Column(name="score", type="float", precision=10, scale=0, nullable=true)
     * @Assert\NotBlank(message="Numero carte d'identité est obligatoire")

     */
    private $score;

    /**
     * @var int|null
     *
     * @ORM\Column(name="nbreExperiance", type="integer", nullable=true)
     * @Assert\NotBlank(message="Numero carte d'identité est obligatoire")

     */
    private $nbreexperiance;

    /**
     * @var bool|null
     *
     * @ORM\Column(name="isverified", type="boolean", nullable=true)
     */
    private $isverified;

    /** 
     * @var \Doctrine\Common\Collections\Collection
     *
     * @ORM\ManyToMany(targetEntity="Event", mappedBy="iduser")
     */
    private $eventid;

    /**
     * Constructor
     */
    public function __construct()
    {
        $this->eventid = new \Doctrine\Common\Collections\ArrayCollection();
    }
    public function getIduser(): ?int
    {
        return $this->iduser;
    }

    public function getNomuser(): ?string
    {
        return $this->nomuser;
    }

    public function setNomuser(string $name): self
    {
        $this->nomuser = $name;

        return $this;
    }

    public function getPrenomuser(): ?string
    {
        return $this->prenomuser;
    }

    public function setPrenomuser(string $name): self
    {
        $this->prenomuser = $name;

        return $this;
    }
    public function getEmail(): ?string
    {
        return $this->email;
    }

    public function setEmail(string $email): self
    {
        $this->email = $email;

        return $this;
    }

    public function getTeluser(): ?string
    {
        return $this->teluser;
    }

    public function setTeluser(string $tel): self
    {
        $this->teluser = $tel;

        return $this;
    }
    public function getMotdepasse(): ?string
    {
        return $this->motdepasse;
    }

    public function setMotdepasse(string $mdp): self
    {
        $this->motdepasse = $mdp;

        return $this;
    }

    public function getImage(): ?string
    {
        return $this->image;
    }

    public function setImage(string $img): self
    {
        $this->image = $image;

        return $this;
    }
    public function getRole(): ?string
    {
        return $this->role;
    }
    public function setRole(string $role): self
    {
        $this->role = $role;

        return $this;
    }
}
