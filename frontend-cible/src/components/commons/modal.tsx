import { ReactNode } from "react";
import { Icon } from "./icon";

interface ModalProps {
    // Props
    isOpen?: boolean;
    title?: string;
    children: ReactNode;
    size?: 'sm' | 'md' | 'lg' | 'xl';
    showCloseButton?: boolean;
    // Callbacks
    onClose: () => void;
}

export default function Modal(
    // Props
    { isOpen,
        onClose,
        title,
        children,
        size = 'md',
        showCloseButton = true,
    }: ModalProps) {
    if (!isOpen) return null;

    const sizeClasses = {
        sm: 'max-w-sm',
        md: 'max-w-md',
        lg: 'max-w-lg',
        xl: 'max-w-xl',
    };

    // State


    // Content
    if (!isOpen) return null;
    return (
        <div
            className="fixed inset-0 bg-black/75 flex items-center justify-center z-50 p-4"
            onClick={onClose}
        >
            <div
                className={`bg-[#121215] border border-white/5 rounded-lg ${sizeClasses[size]} w-full shadow-xl`}
                onClick={(e) => e.stopPropagation()}
            >
                {/* Header */}
                {showCloseButton && (
                    <div className="flex items-center justify-end p-4">
                        <Icon icon="circle-xmark" size="lg" className="text-zinc-400 hover:text-zinc-200 transition-colors hover:cursor-pointer" onClick={onClose}>

                        </Icon>
                    </div>
                )}

                {title && (
                    <div className="flex flex-col justify-center items-center">
                        <h2 className="text-2xl font-semibold text-white tracking-tight">{title}</h2>
                    </div>
                )}

                {/* Content */}
                <div className="p-6">
                    {children}
                </div>
            </div>
        </div>
    );
}