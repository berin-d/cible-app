import { Icon } from "./icon";
import { IconProp } from "@fortawesome/fontawesome-svg-core";

interface ButtonProps {
  text: string;
  type?: "button" | "submit" | "reset";
  variant?: "primary" | "secondary" | "danger";
  disabled?: boolean;
  iconName?: IconProp;
  fullWidth?: boolean;
  size?: "sm" | "md" | "lg";
  animation?: "none" | "scale" | "fade";
  onClick?: () => void;
}

// ✅ Styles tailles
const sizeStyles = {
  sm: "text-xs py-1.5 px-3",
  md: "text-sm py-2.5 px-5",
  lg: "text-base py-3 px-6",
};

// ✅ Styles animations
const animationStyles = {
  none: "",
  scale: "hover:scale-105 active:scale-95",
  fade: "hover:opacity-80",
};

export default function Button({
  text,
  type = "button",
  variant = "primary",
  disabled,
  iconName,
  onClick,
  fullWidth,
  size = "md",
  animation = "scale",
}: ButtonProps) {
  // ✅ Styles selon le variant
  const variantStyles = {
    primary: "bg-emerald-500 hover:bg-emerald-400 text-zinc-950",
    secondary:
      "bg-transparent border border-zinc-700 text-zinc-100 hover:bg-zinc-800",
    danger: "bg-red-600 hover:bg-red-500 text-white",
  };

  return (
    <button
      type={type}
      onClick={onClick}
      disabled={disabled}
      className={`
        ${variantStyles[variant]}
        ${sizeStyles[size]}
        ${animationStyles[animation]}
        ${fullWidth ? "w-full" : ""}
        flex items-center justify-center gap-2
        font-semibold rounded-lg
        transition-all
        hover:cursor-pointer
        disabled:opacity-50 disabled:cursor-not-allowed
      `}
    >
      {iconName && <Icon icon={iconName} />}
      {text}
    </button>
  );
}