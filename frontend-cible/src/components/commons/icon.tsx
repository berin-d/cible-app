import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { IconProp, SizeProp } from '@fortawesome/fontawesome-svg-core';

export interface IconProps {
  /** Nom de l'icône (ex: 'home', 'user', ['fab', 'facebook']) */
  icon: IconProp;
  size?: SizeProp;
  color?: string;
  className?: string;
  rotation?: 90 | 180 | 270;
  flip?: 'horizontal' | 'vertical' | 'both';
  /** Animation de spin */
  spin?: boolean;
  /** Animation de pulse */
  pulse?: boolean;
  /** Fonction appelée au clic */
  onClick?: () => void;
  /** Aria label pour l'accessibilité */
  ariaLabel?: string;
}

export const Icon: React.FC<IconProps> = ({
  icon,
  size = '1x',
  color,
  className = '',
  rotation,
  flip,
  spin = false,
  pulse = false,
  onClick,
  ariaLabel,
}) => {
  return (
    <FontAwesomeIcon
      icon={icon}
      size={size}
      color={color}
      className={`custom-icon ${className} ${onClick ? 'clickable' : ''}`}
      rotation={rotation}
      flip={flip}
      spin={spin}
      pulse={pulse}
      onClick={onClick}
      aria-label={ariaLabel}
    />
  );
};